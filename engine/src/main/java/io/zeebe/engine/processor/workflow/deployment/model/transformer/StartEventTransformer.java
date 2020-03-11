/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.processor.workflow.deployment.model.transformer;

import io.zeebe.engine.processor.workflow.deployment.model.BpmnStep;
import io.zeebe.engine.processor.workflow.deployment.model.element.ExecutableCatchEventElement;
import io.zeebe.engine.processor.workflow.deployment.model.element.ExecutableFlowElementContainer;
import io.zeebe.engine.processor.workflow.deployment.model.element.ExecutableStartEvent;
import io.zeebe.engine.processor.workflow.deployment.model.element.ExecutableWorkflow;
import io.zeebe.engine.processor.workflow.deployment.model.transformation.ModelElementTransformer;
import io.zeebe.engine.processor.workflow.deployment.model.transformation.TransformContext;
import io.zeebe.model.bpmn.instance.FlowNode;
import io.zeebe.model.bpmn.instance.StartEvent;
import io.zeebe.protocol.record.intent.WorkflowInstanceIntent;

public final class StartEventTransformer implements ModelElementTransformer<StartEvent> {

  @Override
  public Class<StartEvent> getType() {
    return StartEvent.class;
  }

  @Override
  public void transform(final StartEvent element, final TransformContext context) {
    final ExecutableWorkflow workflow = context.getCurrentWorkflow();
    final ExecutableStartEvent startEvent =
        workflow.getElementById(element.getId(), ExecutableStartEvent.class);

    startEvent.setInterrupting(element.isInterrupting());

    if (element.getScope() instanceof FlowNode) {
      final FlowNode scope = (FlowNode) element.getScope();

      final ExecutableFlowElementContainer subprocess =
          workflow.getElementById(scope.getId(), ExecutableFlowElementContainer.class);
      subprocess.addStartEvent(startEvent);
    } else {
      // top-level start event
      workflow.addStartEvent(startEvent);
    }

    bindLifecycle(startEvent);
  }

  private void bindLifecycle(final ExecutableCatchEventElement startEvent) {
    startEvent.bindLifecycleState(
        WorkflowInstanceIntent.EVENT_OCCURRED, BpmnStep.START_EVENT_EVENT_OCCURRED);
  }
}
