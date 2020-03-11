/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.msgpack.mapping;

import static io.zeebe.msgpack.mapping.MsgPackTreeNodeIdConstructor.construct;

import io.zeebe.msgpack.spec.MsgPackWriter;
import org.agrona.BitUtil;
import org.agrona.DirectBuffer;
import org.agrona.ExpandableArrayBuffer;
import org.agrona.concurrent.UnsafeBuffer;

public final class MappingDiff implements MsgPackDiff {

  public static final DirectBuffer CONSTANTS_DOCUMENT;
  /*
   * - offset
   * - length
   * - sourceDocument (1) or nullDocument (0)
   */
  private static final int RESULT_ENTRY_LENGTH = 2 * BitUtil.SIZE_OF_INT + BitUtil.SIZE_OF_BYTE;

  static {
    final UnsafeBuffer buffer = new UnsafeBuffer(new byte[2]);
    final MsgPackWriter writer = new MsgPackWriter();
    writer.wrap(buffer, 0);
    writer.writeMapHeader(0);
    writer.writeNil();
    CONSTANTS_DOCUMENT = buffer;
  }

  private final ExpandableArrayBuffer mappingResults = new ExpandableArrayBuffer();
  private Mapping[] mappings;
  private DirectBuffer document;

  public void init(final Mapping[] mappings, final DirectBuffer document) {
    this.mappings = mappings;
    this.document = document;
  }

  public int getResultOffset(final int mappingIndex) {
    return mappingResults.getInt(mapToResultIndex(mappingIndex));
  }

  public int getResultLength(final int mappingIndex) {
    return mappingResults.getInt(mapToResultIndex(mappingIndex) + BitUtil.SIZE_OF_INT);
  }

  public boolean isMappedFromSourceDocument(final int mappingIndex) {
    return mappingResults.getByte(mapToResultIndex(mappingIndex) + (2 * BitUtil.SIZE_OF_INT)) == 1;
  }

  private static int mapToResultIndex(final int mappingIndex) {
    return mappingIndex * RESULT_ENTRY_LENGTH;
  }

  public void setResult(final int mappingIndex, final int offset, final int length) {
    setResult(mappingIndex, offset, length, true);
  }

  public void setNullResult(final int mappingIndex) {
    setResult(mappingIndex, 1, 1, false);
  }

  public void setEmptyMapResult(final int mappingIndex) {
    setResult(mappingIndex, 0, 1, false);
  }

  private void setResult(
      final int mappingIndex,
      final int offset,
      final int length,
      final boolean fromSourceDocument) {
    int mappingResultOffset = mapToResultIndex(mappingIndex);
    mappingResults.putInt(mappingResultOffset, offset);

    mappingResultOffset += BitUtil.SIZE_OF_INT;
    mappingResults.putInt(mappingResultOffset, length);

    mappingResultOffset += BitUtil.SIZE_OF_INT;
    mappingResults.putByte(mappingResultOffset, fromSourceDocument ? (byte) 1 : (byte) 0);
  }

  private boolean isIndex(final String nodeName) {
    final int len = nodeName.length();
    for (int i = 0; i < len; i++) {
      final char currentChar = nodeName.charAt(i);
      if (currentChar < '0' || currentChar > '9') {
        return false;
      }
    }
    return true;
  }

  @Override
  public void mergeInto(final MsgPackTree document) {
    final int constantsDocumentId = document.addDocument(CONSTANTS_DOCUMENT);
    final int ourDocumentId = document.addDocument(this.document);

    for (int i = 0; i < mappings.length; i++) {
      final Mapping mapping = mappings[i];
      final String[] targetPathElements = mapping.getTargetPointer().getPathElements();

      String parentId = "";

      for (int j = 0; j < targetPathElements.length; j++) {
        final String nodeName = targetPathElements[j];

        if (j == targetPathElements.length - 1) {
          final int valueOffset = getResultOffset(i);
          final int valueLength = getResultLength(i);
          final int documentId =
              isMappedFromSourceDocument(i) ? ourDocumentId : constantsDocumentId;

          mergeValueInto(
              document,
              parentId,
              nodeName,
              mapping.getType(),
              documentId,
              valueOffset,
              valueLength);

        } else {
          parentId = mergeContainerInto(document, parentId, nodeName, targetPathElements[j + 1]);
        }
      }
    }
  }

  private String mergeContainerInto(
      final MsgPackTree document,
      final String parentId,
      final String nodeName,
      final String nextPathElement) {

    final String nodeId = construct(parentId, nodeName);

    if (document.hasNode(nodeId)) {
      if (!isIndex(nextPathElement)) {
        document.convertToMapNode(nodeId);
      }

      return nodeId;
    } else {
      if (isIndex(nextPathElement)) {
        return document.addArrayNode(parentId, nodeName);
      } else {
        return document.addMapNode(parentId, nodeName);
      }
    }
  }

  private void mergeValueInto(
      final MsgPackTree document,
      final String parentId,
      final String nodeName,
      final Mapping.Type mappingType,
      final int documentId,
      final int valueOffset,
      final int valueLength) {
    switch (mappingType) {
      case COLLECT:
        document.appendToArray(parentId, nodeName, documentId, valueOffset, valueLength);
        break;
      case PUT:
      default:
        document.addValueNode(parentId, nodeName, documentId, valueOffset, valueLength);
        break;
    }
  }
}
