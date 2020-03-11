/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.state.message;

import static io.zeebe.db.impl.ZeebeDbConstants.ZB_DB_BYTE_ORDER;
import static io.zeebe.util.buffer.BufferUtil.readIntoBuffer;
import static io.zeebe.util.buffer.BufferUtil.writeIntoBuffer;

import io.zeebe.db.DbValue;
import io.zeebe.util.buffer.BufferUtil;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

public final class WorkflowInstanceSubscription implements DbValue {

  private static final int STATE_OPENING = 0;
  private static final int STATE_OPENED = 1;
  private static final int STATE_CLOSING = 2;

  private final DirectBuffer messageName = new UnsafeBuffer();
  private final DirectBuffer correlationKey = new UnsafeBuffer();
  private final DirectBuffer targetElementId = new UnsafeBuffer();
  private final DirectBuffer bpmnProcessId = new UnsafeBuffer();

  private long workflowInstanceKey;
  private long elementInstanceKey;
  private int subscriptionPartitionId;
  private long commandSentTime;
  private boolean closeOnCorrelate = true;

  private int state = STATE_OPENING;

  public WorkflowInstanceSubscription() {}

  public WorkflowInstanceSubscription(
      final long workflowInstanceKey,
      final long elementInstanceKey,
      final DirectBuffer bpmnProcessId) {
    this.workflowInstanceKey = workflowInstanceKey;
    this.elementInstanceKey = elementInstanceKey;
    this.bpmnProcessId.wrap(bpmnProcessId);
  }

  public WorkflowInstanceSubscription(
      final long workflowInstanceKey,
      final long elementInstanceKey,
      final DirectBuffer targetElementId,
      final DirectBuffer bpmnProcessId,
      final DirectBuffer messageName,
      final DirectBuffer correlationKey,
      final long commandSentTime,
      final boolean closeOnCorrelate) {
    this(workflowInstanceKey, elementInstanceKey, bpmnProcessId);

    this.targetElementId.wrap(targetElementId);
    this.commandSentTime = commandSentTime;
    this.messageName.wrap(messageName);
    this.correlationKey.wrap(correlationKey);
    this.closeOnCorrelate = closeOnCorrelate;
  }

  public DirectBuffer getMessageName() {
    return messageName;
  }

  public void setMessageName(final DirectBuffer messageName) {
    this.messageName.wrap(messageName);
  }

  public DirectBuffer getCorrelationKey() {
    return correlationKey;
  }

  public void setCorrelationKey(final DirectBuffer correlationKey) {
    this.correlationKey.wrap(correlationKey);
  }

  public DirectBuffer getTargetElementId() {
    return targetElementId;
  }

  public void setTargetElementId(final DirectBuffer targetElementId) {
    this.targetElementId.wrap(targetElementId);
  }

  public long getWorkflowInstanceKey() {
    return workflowInstanceKey;
  }

  public void setWorkflowInstanceKey(final long workflowInstanceKey) {
    this.workflowInstanceKey = workflowInstanceKey;
  }

  public long getElementInstanceKey() {
    return elementInstanceKey;
  }

  public void setElementInstanceKey(final long elementInstanceKey) {
    this.elementInstanceKey = elementInstanceKey;
  }

  public DirectBuffer getBpmnProcessId() {
    return bpmnProcessId;
  }

  public void setBpmnProcessId(final DirectBuffer bpmnProcessId) {
    this.bpmnProcessId.wrap(bpmnProcessId);
  }

  public long getCommandSentTime() {
    return commandSentTime;
  }

  public void setCommandSentTime(final long commandSentTime) {
    this.commandSentTime = commandSentTime;
  }

  public int getSubscriptionPartitionId() {
    return subscriptionPartitionId;
  }

  public void setSubscriptionPartitionId(final int subscriptionPartitionId) {
    this.subscriptionPartitionId = subscriptionPartitionId;
  }

  public boolean shouldCloseOnCorrelate() {
    return closeOnCorrelate;
  }

  public void setCloseOnCorrelate(final boolean closeOnCorrelate) {
    this.closeOnCorrelate = closeOnCorrelate;
  }

  public boolean isOpening() {
    return state == STATE_OPENING;
  }

  public boolean isClosing() {
    return state == STATE_CLOSING;
  }

  public void setOpened() {
    state = STATE_OPENED;
  }

  public void setClosing() {
    state = STATE_CLOSING;
  }

  @Override
  public void wrap(final DirectBuffer buffer, int offset, final int length) {
    final int startOffset = offset;
    workflowInstanceKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    elementInstanceKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    subscriptionPartitionId = buffer.getInt(offset, ZB_DB_BYTE_ORDER);
    offset += Integer.BYTES;

    commandSentTime = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    state = buffer.getInt(offset, ZB_DB_BYTE_ORDER);
    offset += Integer.BYTES;

    closeOnCorrelate = buffer.getByte(offset) == 1;
    offset += 1;

    offset = readIntoBuffer(buffer, offset, messageName);
    offset = readIntoBuffer(buffer, offset, correlationKey);
    offset = readIntoBuffer(buffer, offset, targetElementId);
    offset = readIntoBuffer(buffer, offset, bpmnProcessId);

    assert (offset - startOffset) == length : "End offset differs from length";
  }

  @Override
  public int getLength() {
    return 1
        + Long.BYTES * 3
        + Integer.BYTES * 6
        + messageName.capacity()
        + correlationKey.capacity()
        + targetElementId.capacity()
        + bpmnProcessId.capacity();
  }

  @Override
  public void write(final MutableDirectBuffer buffer, int offset) {
    buffer.putLong(offset, workflowInstanceKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, elementInstanceKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putInt(offset, subscriptionPartitionId, ZB_DB_BYTE_ORDER);
    offset += Integer.BYTES;

    buffer.putLong(offset, commandSentTime, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putInt(offset, state, ZB_DB_BYTE_ORDER);
    offset += Integer.BYTES;

    buffer.putByte(offset, (byte) (closeOnCorrelate ? 1 : 0));
    offset += 1;

    offset = writeIntoBuffer(buffer, offset, messageName);
    offset = writeIntoBuffer(buffer, offset, correlationKey);
    offset = writeIntoBuffer(buffer, offset, targetElementId);
    offset = writeIntoBuffer(buffer, offset, bpmnProcessId);

    assert offset == getLength() : "End offset differs with getLength()";
  }

  @Override
  public String toString() {
    return "WorkflowInstanceSubscription{"
        + "elementInstanceKey="
        + elementInstanceKey
        + ", messageName="
        + BufferUtil.bufferAsString(messageName)
        + ", correlationKey="
        + BufferUtil.bufferAsString(correlationKey)
        + ", workflowInstanceKey="
        + workflowInstanceKey
        + ", subscriptionPartitionId="
        + subscriptionPartitionId
        + ", commandSentTime="
        + commandSentTime
        + ", state="
        + state
        + '}';
  }
}
