/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.msgpack.filter;

import io.zeebe.msgpack.query.MsgPackTraversalContext;
import io.zeebe.msgpack.spec.MsgPackToken;
import io.zeebe.msgpack.spec.MsgPackType;
import io.zeebe.msgpack.util.ByteUtil;
import java.nio.charset.StandardCharsets;
import org.agrona.BitUtil;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

/** Only works for maps that have scalar values as keys */
public final class MapValueWithKeyFilter implements MsgPackFilter {
  public static final int NO_MATCHING_VALUE = -1;

  @Override
  public boolean matches(
      final MsgPackTraversalContext ctx,
      final DirectBuffer filterContext,
      final MsgPackToken value) {

    if (ctx.hasElements() && ctx.isMap()) {
      final MutableDirectBuffer dynamicContext = ctx.dynamicContext();

      final int currentElement = ctx.currentElement();
      if (currentElement == 0) {
        // initialization
        dynamicContext.putInt(0, NO_MATCHING_VALUE);
      }

      final int matchingValueIndex = dynamicContext.getInt(0);
      final int queryLength = filterContext.getInt(0);

      if (currentElement == matchingValueIndex) {
        dynamicContext.putInt(0, NO_MATCHING_VALUE);
        return true;
      }
      if (ctx.currentElement() % 2 == 0
          && // map keys have even positions
          value.getType() == MsgPackType.STRING
          && ByteUtil.equal(
              filterContext,
              BitUtil.SIZE_OF_INT,
              queryLength,
              value.getValueBuffer(),
              0,
              value.getValueBuffer().capacity())) {
        dynamicContext.putInt(0, currentElement + 1);
      }
    }

    return false;
  }

  public static void encodeDynamicContext(
      final MutableDirectBuffer contextBuffer,
      final DirectBuffer keyBuffer,
      final int keyOffset,
      final int keyLength) {
    contextBuffer.putInt(0, keyLength);
    contextBuffer.putBytes(BitUtil.SIZE_OF_INT, keyBuffer, keyOffset, keyLength);
  }

  public static void encodeDynamicContext(
      final MutableDirectBuffer contextBuffer, final String key) {
    final UnsafeBuffer keyBuffer = new UnsafeBuffer(key.getBytes(StandardCharsets.UTF_8));
    encodeDynamicContext(contextBuffer, keyBuffer, 0, keyBuffer.capacity());
  }
}
