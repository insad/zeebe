/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.processor.workflow.deployment.model.element;

import io.zeebe.model.bpmn.util.time.Timer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.agrona.DirectBuffer;

public class ExecutableCatchEventElement extends ExecutableFlowNode
    implements ExecutableCatchEvent, ExecutableCatchEventSupplier {
  private final List<ExecutableCatchEvent> events = Collections.singletonList(this);

  private ExecutableMessage message;
  private Timer timer;
  private ExecutableError error;
  private boolean interrupting;

  public ExecutableCatchEventElement(final String id) {
    super(id);
  }

  @Override
  public boolean isTimer() {
    return timer != null;
  }

  @Override
  public boolean isMessage() {
    return message != null;
  }

  @Override
  public boolean isError() {
    return error != null;
  }

  @Override
  public ExecutableMessage getMessage() {
    return message;
  }

  public void setMessage(final ExecutableMessage message) {
    this.message = message;
  }

  @Override
  public Timer getTimer() {
    return timer;
  }

  public void setTimer(final Timer timer) {
    this.timer = timer;
  }

  @Override
  public ExecutableError getError() {
    return error;
  }

  public void setError(final ExecutableError error) {
    this.error = error;
  }

  @Override
  public List<ExecutableCatchEvent> getEvents() {
    return events;
  }

  @Override
  public Collection<DirectBuffer> getInterruptingElementIds() {
    return Collections.singleton(getId());
  }

  public boolean interrupting() {
    return interrupting;
  }

  public void setInterrupting(final boolean interrupting) {
    this.interrupting = interrupting;
  }
}
