/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.util.collection;

import static org.agrona.BitUtil.SIZE_OF_INT;

/**
 * Layout
 *
 * <p>*
 *
 * <pre>
 *  +----------------------------+
 *  |           HEADER           |
 *  +----------------------------+
 *  |         DATA SECTION       |
 *  +----------------------------+
 * </pre>
 *
 * Header Layout
 *
 * <pre>
 *   0                   1                   2                   3
 *   0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
 *  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *  |                              SIZE                             |
 *  +---------------------------------------------------------------+
 *  |                       ELEMENT MAX LENGTH                      |
 *  +---------------------------------------------------------------+
 *  |                            CAPACITY                           |
 *  +---------------------------------------------------------------+
 * </pre>
 *
 * Element Layout
 *
 * <pre>
 *   0                   1                   2                   3
 *   0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
 *  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *  |                          ELEMENT LENGTH                       |
 *  +---------------------------------------------------------------+
 *  |                              ELEMENT                          |
 *  +---------------------------------------------------------------+
 * </pre>
 */
public final class CompactListDescriptor {

  public static final int HEADER_OFFSET;

  public static final int SIZE_OFFSET;

  public static final int ELEMENT_MAX_LENGTH_OFFSET;

  public static final int CAPACITY_OFFSET;

  public static final int HEADER_LENGTH;

  public static final int DATA_SECTION_OFFSET;

  public static final int ELEMENT_HEADER_LENGTH;

  public static final int ELEMENT_LENGTH_OFFSET;

  static {
    // list header
    int offset = 0;

    HEADER_OFFSET = offset;

    SIZE_OFFSET = offset;
    offset += SIZE_OF_INT;

    ELEMENT_MAX_LENGTH_OFFSET = offset;
    offset += SIZE_OF_INT;

    CAPACITY_OFFSET = offset;
    offset += SIZE_OF_INT;

    HEADER_LENGTH = offset;

    // data section
    DATA_SECTION_OFFSET = offset;

    // element header
    offset = 0;
    ELEMENT_LENGTH_OFFSET = offset;
    offset += SIZE_OF_INT;

    ELEMENT_HEADER_LENGTH = offset;
  }

  public static int headerOffset() {
    return HEADER_OFFSET;
  }

  public static int sizeOffset() {
    return SIZE_OFFSET;
  }

  public static int elementMaxLengthOffset() {
    return ELEMENT_MAX_LENGTH_OFFSET;
  }

  public static int capacityOffset() {
    return CAPACITY_OFFSET;
  }

  public static int dataSectionOffset() {
    return DATA_SECTION_OFFSET;
  }

  public static int headerLength() {
    return HEADER_LENGTH;
  }

  public static int requiredBufferCapacity(final int framedLength, final int capacity) {
    return HEADER_LENGTH + (framedLength * capacity);
  }

  public static int elementOffset(final int framedLength, final int idx) {
    return HEADER_LENGTH + (framedLength * idx);
  }

  public static int elementLengthOffset(final int offset) {
    return ELEMENT_LENGTH_OFFSET + offset;
  }

  public static int elementDataOffset(final int offset) {
    return ELEMENT_HEADER_LENGTH + offset;
  }

  public static int framedLength(final int length) {
    return ELEMENT_HEADER_LENGTH + length;
  }
}
