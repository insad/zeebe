/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.util.sched;

import io.zeebe.util.CloseableSilently;
import io.zeebe.util.sched.future.ActorFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public abstract class Actor implements CloseableSilently {

  private static final int MAX_CLOSE_TIMEOUT = 300;
  protected final ActorControl actor = new ActorControl(this);

  public String getName() {
    return getClass().getName();
  }

  protected void onActorStarting() {
    // setup
  }

  protected void onActorStarted() {
    // logic
  }

  protected void onActorClosing() {
    // tear down
  }

  protected void onActorClosed() {
    // what ever
  }

  protected void onActorCloseRequested() {
    // notification that timers, conditions, etc. will no longer trigger from now on
  }

  public static Actor wrap(final Consumer<ActorControl> r) {
    return new Actor() {
      @Override
      public String getName() {
        return r.toString();
      }

      @Override
      protected void onActorStarted() {
        r.accept(actor);
      }
    };
  }

  @Override
  public void close() {
    actor.close().join(MAX_CLOSE_TIMEOUT, TimeUnit.SECONDS);
  }

  public ActorFuture<Void> closeAsync() {
    return actor.close();
  }

  public static String buildActorName(final int nodeId, final String name) {
    return String.format("Broker-%d-%s", nodeId, name);
  }
}
