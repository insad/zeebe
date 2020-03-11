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
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

public final class MessageSubscription implements DbValue {

  private final DirectBuffer bpmnProcessId = new UnsafeBuffer();
  private final DirectBuffer messageName = new UnsafeBuffer();
  private final DirectBuffer correlationKey = new UnsafeBuffer();
  private final DirectBuffer messageVariables = new UnsafeBuffer();

  private long workflowInstanceKey;
  private long elementInstanceKey;
  private long messageKey;
  private long commandSentTime;
  private boolean closeOnCorrelate;

  public MessageSubscription() {}

  public MessageSubscription(
      final long workflowInstanceKey,
      final long elementInstanceKey,
      final DirectBuffer bpmnProcessId,
      final DirectBuffer messageName,
      final DirectBuffer correlationKey,
      final boolean closeOnCorrelate) {
    this.workflowInstanceKey = workflowInstanceKey;
    this.elementInstanceKey = elementInstanceKey;

    this.bpmnProcessId.wrap(bpmnProcessId);
    this.messageName.wrap(messageName);
    this.correlationKey.wrap(correlationKey);
    this.closeOnCorrelate = closeOnCorrelate;
  }

  public DirectBuffer getBpmnProcessId() {
    return bpmnProcessId;
  }

  public DirectBuffer getMessageName() {
    return messageName;
  }

  public DirectBuffer getCorrelationKey() {
    return correlationKey;
  }

  public DirectBuffer getMessageVariables() {
    return messageVariables;
  }

  public void setMessageVariables(final DirectBuffer variables) {
    messageVariables.wrap(variables);
  }

  public long getWorkflowInstanceKey() {
    return workflowInstanceKey;
  }

  public long getElementInstanceKey() {
    return elementInstanceKey;
  }

  public void setElementInstanceKey(final long elementInstanceKey) {
    this.elementInstanceKey = elementInstanceKey;
  }

  public long getMessageKey() {
    return messageKey;
  }

  public void setMessageKey(final long messageKey) {
    this.messageKey = messageKey;
  }

  public long getCommandSentTime() {
    return commandSentTime;
  }

  public void setCommandSentTime(final long commandSentTime) {
    this.commandSentTime = commandSentTime;
  }

  public boolean isCorrelating() {
    return commandSentTime > 0;
  }

  public boolean shouldCloseOnCorrelate() {
    return closeOnCorrelate;
  }

  public void setCloseOnCorrelate(final boolean closeOnCorrelate) {
    this.closeOnCorrelate = closeOnCorrelate;
  }

  @Override
  public void wrap(final DirectBuffer buffer, int offset, final int length) {
    workflowInstanceKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    elementInstanceKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    messageKey = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    commandSentTime = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    closeOnCorrelate = buffer.getByte(offset) == 1;
    offset += 1;

    offset = readIntoBuffer(buffer, offset, messageName);
    offset = readIntoBuffer(buffer, offset, correlationKey);
    offset = readIntoBuffer(buffer, offset, messageVariables);
    readIntoBuffer(buffer, offset, bpmnProcessId);
  }

  @Override
  public int getLength() {
    return 1
        + Long.BYTES * 4
        + Integer.BYTES * 4
        + messageName.capacity()
        + correlationKey.capacity()
        + messageVariables.capacity()
        + bpmnProcessId.capacity();
  }

  @Override
  public void write(final MutableDirectBuffer buffer, int offset) {
    buffer.putLong(offset, workflowInstanceKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, elementInstanceKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, messageKey, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putLong(offset, commandSentTime, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;

    buffer.putByte(offset, (byte) (closeOnCorrelate ? 1 : 0));
    offset += 1;

    offset = writeIntoBuffer(buffer, offset, messageName);
    offset = writeIntoBuffer(buffer, offset, correlationKey);
    offset = writeIntoBuffer(buffer, offset, messageVariables);
    offset = writeIntoBuffer(buffer, offset, bpmnProcessId);

    assert offset == getLength() : "End offset differs with getLength()";
  }
}
