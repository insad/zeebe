/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.state.instance;

import static io.zeebe.db.impl.ZeebeDbConstants.ZB_DB_BYTE_ORDER;
import static io.zeebe.util.buffer.BufferUtil.readIntoBuffer;
import static io.zeebe.util.buffer.BufferUtil.writeIntoBuffer;

import io.zeebe.db.DbValue;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

public final class TimerInstance implements DbValue {

  public static final int NO_ELEMENT_INSTANCE = -1;

  private final DirectBuffer handlerNodeId = new UnsafeBuffer(0, 0);
  private long workflowKey;
  private long key;
  private long elementInstanceKey;
  private long workflowInstanceKey;
  private long dueDate;
  private int repetitions;

  public long getElementInstanceKey() {
    return elementInstanceKey;
  }

  public void setElementInstanceKey(final long elementInstanceKey) {
    this.elementInstanceKey = elementInstanceKey;
  }

  public long getDueDate() {
    return dueDate;
  }

  public void setDueDate(final long dueDate) {
    this.dueDate = dueDate;
  }

  public long getKey() {
    return key;
  }

  public void setKey(final long key) {
    this.key = key;
  }

  public DirectBuffer getHandlerNodeId() {
    return handlerNodeId;
  }

  public void setHandlerNodeId(final DirectBuffer handlerNodeId) {
    this.handlerNodeId.wrap(handlerNodeId);
  }

  public int getRepetitions() {
    return repetitions;
  }

  public void setRepetitions(final int repetitions) {
    this.repetitions = repetitions;
  }

  public long getWorkflowKey() {
    return this.workflowKey;
  }

  public void setWorkflowKey(final long workflowKey) {
    this.workflowKey = workflowKey;
  }

  public long getWorkflowInstanceKey() {
    return workflowInstanceKey;
  }

  public void setWorkflowInstanceKey(final long workflowInstanceKey) {
    this.workflowInstanceKey = workflowInstanceKey;
  }

  @Override
  public int getLength() {
    return 5 * Long.BYTES + 2 * Integer.BYTES + handlerNodeId.capacity();
  }

  @Override
  public void write(final MutableDirectBuffer buffer, int offset) {
    buffer.putLong(offset, elementInstanceKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, workflowInstanceKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, dueDate, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, key, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, workflowKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putInt(offset, repetitions, ZB_DB_BYTE_ORDER);
    offset += Integer.BYTES;

    offset = writeIntoBuffer(buffer, offset, handlerNodeId);
    assert offset == getLength() : "End offset differs from getLength()";
  }

  @Override
  public void wrap(final DirectBuffer buffer, int offset, final int length) {
    elementInstanceKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    workflowInstanceKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    dueDate = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    key = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    workflowKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    repetitions = buffer.getInt(offset, ZB_DB_BYTE_ORDER);
    offset += Integer.BYTES;

    offset = readIntoBuffer(buffer, offset, handlerNodeId);
    assert offset == length : "End offset differs from length";
  }
}
