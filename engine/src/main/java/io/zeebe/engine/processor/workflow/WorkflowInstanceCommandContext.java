/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.processor.workflow;

import io.zeebe.engine.processor.TypedRecord;
import io.zeebe.engine.processor.TypedResponseWriter;
import io.zeebe.engine.processor.TypedStreamWriter;
import io.zeebe.engine.state.instance.ElementInstance;
import io.zeebe.engine.state.instance.ElementInstanceState;
import io.zeebe.protocol.impl.record.value.workflowinstance.WorkflowInstanceRecord;
import io.zeebe.protocol.record.RejectionType;
import io.zeebe.protocol.record.intent.WorkflowInstanceIntent;

public final class WorkflowInstanceCommandContext {

  private final EventOutput eventOutput;
  private final ElementInstanceState elementInstanceState;

  private TypedRecord<WorkflowInstanceRecord> record;
  private ElementInstance elementInstance;
  private TypedResponseWriter responseWriter;
  private TypedStreamWriter streamWriter;

  public WorkflowInstanceCommandContext(
      final EventOutput eventOutput, final ElementInstanceState elementInstanceState) {
    this.eventOutput = eventOutput;
    this.elementInstanceState = elementInstanceState;
  }

  public WorkflowInstanceIntent getCommand() {
    return (WorkflowInstanceIntent) record.getIntent();
  }

  public TypedRecord<WorkflowInstanceRecord> getRecord() {
    return record;
  }

  public void setRecord(final TypedRecord<WorkflowInstanceRecord> record) {
    this.record = record;
  }

  public EventOutput getOutput() {
    return eventOutput;
  }

  public ElementInstance getElementInstance() {
    return elementInstance;
  }

  public void setElementInstance(final ElementInstance elementInstance) {
    this.elementInstance = elementInstance;
  }

  public TypedResponseWriter getResponseWriter() {
    return responseWriter;
  }

  public void setResponseWriter(final TypedResponseWriter responseWriter) {
    this.responseWriter = responseWriter;
  }

  public void setStreamWriter(final TypedStreamWriter writer) {
    streamWriter = writer;
    eventOutput.setStreamWriter(writer);
  }

  public ElementInstanceState getElementInstanceState() {
    return elementInstanceState;
  }

  public void reject(final RejectionType rejectionType, final String reason) {
    streamWriter.appendRejection(record, rejectionType, reason);
    responseWriter.writeRejectionOnCommand(record, rejectionType, reason);
  }
}
