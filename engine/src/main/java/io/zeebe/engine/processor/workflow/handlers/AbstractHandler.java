/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.processor.workflow.handlers;

import io.zeebe.engine.Loggers;
import io.zeebe.engine.processor.workflow.BpmnStepContext;
import io.zeebe.engine.processor.workflow.BpmnStepHandler;
import io.zeebe.engine.processor.workflow.WorkflowInstanceLifecycle;
import io.zeebe.engine.processor.workflow.deployment.model.element.ExecutableFlowElement;
import io.zeebe.engine.state.instance.ElementInstance;
import io.zeebe.protocol.record.intent.WorkflowInstanceIntent;

public abstract class AbstractHandler<T extends ExecutableFlowElement>
    implements BpmnStepHandler<T> {
  private final WorkflowInstanceIntent nextState;

  /**
   * @param nextState the next state in the lifecycle; if one is given, will immediately move on to
   *     this state if successfully handled, otherwise will not. Asynchronous handlers should thus
   *     pass null here.
   */
  public AbstractHandler(final WorkflowInstanceIntent nextState) {
    this.nextState = nextState;
  }

  /**
   * Delegates handling the state logic to subclasses, and moves to the next state iff there is a
   * next state to move to and it is a synchronous handler.
   *
   * @param context current step context
   */
  @Override
  public void handle(final BpmnStepContext<T> context) {
    if (shouldHandleState(context)) {
      final boolean handled = handleState(context);

      if (handled && shouldTransition()) {
        transitionToNext(context);
      }
    } else {
      Loggers.WORKFLOW_PROCESSOR_LOGGER.debug(
          "Skipping record [key: {}, intent: {}, value: {}] due to step guard; in-memory element is {}",
          context.getKey(),
          context.getState(),
          context.getValue(),
          context.getElementInstance());
    }
  }

  /**
   * To be overridden by subclasses.
   *
   * @param context current step context
   * @return true if ready successful, false otherwise
   */
  protected abstract boolean handleState(BpmnStepContext<T> context);

  protected boolean shouldHandleState(final BpmnStepContext<T> context) {
    return true;
  }

  protected boolean isRootScope(final BpmnStepContext<T> context) {
    return context.getValue().getFlowScopeKey() == -1;
  }

  /**
   * Returns true if the current record intent is the same as the element's current state. This is
   * primarily to ensure we're not processing concurrent state transitions (e.g. writing
   * ELEMENT_ACTIVATING and ELEMENT_ACTIVATED in the same step will transition the element to
   * ACTIVATED, and we shouldn't process the ELEMENT_ACTIVATING in that case).
   */
  protected boolean isStateSameAsElementState(final BpmnStepContext<T> context) {
    return context.getElementInstance() != null
        && context.getState() == context.getElementInstance().getState();
  }

  protected boolean isElementActive(final ElementInstance instance) {
    return instance != null && instance.isActive();
  }

  protected boolean isElementTerminating(final ElementInstance instance) {
    return instance != null && instance.isTerminating();
  }

  protected boolean shouldTransition() {
    return nextState != null;
  }

  protected void transitionToNext(final BpmnStepContext<T> context) {
    this.transitionTo(context, nextState);
  }

  protected void transitionTo(
      final BpmnStepContext<T> context, final WorkflowInstanceIntent nextState) {
    final ElementInstance elementInstance = context.getElementInstance();
    final WorkflowInstanceIntent state = elementInstance.getState();

    assert WorkflowInstanceLifecycle.canTransition(state, nextState)
        : String.format("cannot transition from '%s' to '%s'", state, nextState);

    context.getOutput().appendFollowUpEvent(context.getKey(), nextState, context.getValue());

    // TODO: this is an ugly workaround which should be removed once we have a better workflow
    // instance state abstraction: essentially, whenever transitioning to a terminating state, we
    // want to reject any potential event triggers
    // https://github.com/zeebe-io/zeebe/issues/1980
    if (nextState == WorkflowInstanceIntent.ELEMENT_COMPLETING
        || nextState == WorkflowInstanceIntent.ELEMENT_TERMINATING) {
      context.getStateDb().getEventScopeInstanceState().shutdownInstance(context.getKey());
    }
  }

  /**
   * @return true if an interrupting event (e.g., interrupting event subprocess) occurred and it
   *     wasn't produced by the current element.
   */
  protected boolean isElementInterrupted(final BpmnStepContext<T> context) {
    if (context.getFlowScopeInstance() != null) {
      final long interruptingKey = context.getFlowScopeInstance().getInterruptingEventKey();
      return interruptingKey != -1 && interruptingKey != context.getKey();
    }

    return false;
  }
}
