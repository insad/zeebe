/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.broker.transport.commandapi;

import com.netflix.concurrency.limits.Limiter.Listener;
import io.zeebe.broker.Loggers;
import io.zeebe.transport.RemoteAddress;
import io.zeebe.transport.ServerOutput;
import io.zeebe.transport.backpressure.RequestLimiter;
import java.util.Optional;
import org.agrona.DirectBuffer;

public class RateLimitedCommandApiMessageHandler extends CommandApiMessageHandler {

  private final RequestLimiter limiter;

  public RateLimitedCommandApiMessageHandler(RequestLimiter limiter) {
    super();
    this.limiter = limiter;
  }

  @Override
  public boolean onRequest(
      ServerOutput output,
      RemoteAddress remoteAddress,
      DirectBuffer buffer,
      int offset,
      int length,
      long requestId) {
    final Optional<Listener> acquire = limiter.onRequest();
    if (acquire.isPresent()) {
      limiter.registerListener(requestId, acquire.get());
      return super.onRequest(output, remoteAddress, buffer, offset, length, requestId);
    } else {
      Loggers.TRANSPORT_LOGGER.info("Requests over limit {}, dropping.", limiter.getLimit());
      return errorResponseWriter
          .internalError("Backpressure")
          .tryWriteResponse(output, remoteAddress.getStreamId(), requestId);
    }
  }
}
