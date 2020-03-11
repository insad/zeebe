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
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

public final class ArrayIndexFilter implements MsgPackFilter {

  @Override
  public boolean matches(
      final MsgPackTraversalContext ctx,
      final DirectBuffer filterContext,
      final MsgPackToken value) {
    final int queryIndex = filterContext.getInt(0);
    return !ctx.isMap() && queryIndex == ctx.currentElement();
  }

  public static void encodeDynamicContext(
      final MutableDirectBuffer contextBuffer, final int arrayIndex) {
    contextBuffer.putInt(0, arrayIndex);
  }
}
