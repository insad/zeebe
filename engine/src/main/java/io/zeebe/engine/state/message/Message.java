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

public final class Message implements DbValue {

  private final DirectBuffer name = new UnsafeBuffer();
  private final DirectBuffer correlationKey = new UnsafeBuffer();
  private final DirectBuffer variables = new UnsafeBuffer();
  private final DirectBuffer id = new UnsafeBuffer();
  private long key;
  private long timeToLive;
  private long deadline;

  public Message() {}

  public Message(
      final long key,
      final DirectBuffer name,
      final DirectBuffer correlationKey,
      final DirectBuffer variables,
      final DirectBuffer id,
      final long timeToLive,
      final long deadline) {
    this.name.wrap(name);
    this.correlationKey.wrap(correlationKey);
    this.variables.wrap(variables);
    this.id.wrap(id);

    this.key = key;
    this.timeToLive = timeToLive;
    this.deadline = deadline;
  }

  public DirectBuffer getName() {
    return name;
  }

  public DirectBuffer getCorrelationKey() {
    return correlationKey;
  }

  public DirectBuffer getVariables() {
    return variables;
  }

  public DirectBuffer getId() {
    return id;
  }

  public long getTimeToLive() {
    return timeToLive;
  }

  public long getDeadline() {
    return deadline;
  }

  public long getKey() {
    return key;
  }

  @Override
  public void wrap(final DirectBuffer buffer, int offset, final int length) {
    offset = readIntoBuffer(buffer, offset, name);
    offset = readIntoBuffer(buffer, offset, correlationKey);
    offset = readIntoBuffer(buffer, offset, variables);
    offset = readIntoBuffer(buffer, offset, id);

    timeToLive = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;
    deadline = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
    offset += Long.BYTES;
    key = buffer.getLong(offset, ZB_DB_BYTE_ORDER);
  }

  @Override
  public int getLength() {
    return name.capacity()
        + correlationKey.capacity()
        + variables.capacity()
        + id.capacity()
        + Integer.BYTES * 4
        + Long.BYTES * 3;
  }

  @Override
  public void write(final MutableDirectBuffer buffer, final int offset) {
    int valueOffset = offset;
    valueOffset = writeIntoBuffer(buffer, valueOffset, name);
    valueOffset = writeIntoBuffer(buffer, valueOffset, correlationKey);
    valueOffset = writeIntoBuffer(buffer, valueOffset, variables);
    valueOffset = writeIntoBuffer(buffer, valueOffset, id);

    buffer.putLong(valueOffset, timeToLive, ZB_DB_BYTE_ORDER);
    valueOffset += Long.BYTES;
    buffer.putLong(valueOffset, deadline, ZB_DB_BYTE_ORDER);
    valueOffset += Long.BYTES;
    buffer.putLong(valueOffset, key, ZB_DB_BYTE_ORDER);
    valueOffset += Long.BYTES;
    assert (valueOffset - offset) == getLength() : "End offset differs with getLength()";
  }
}
