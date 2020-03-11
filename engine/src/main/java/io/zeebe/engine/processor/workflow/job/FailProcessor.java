/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.processor.workflow.job;

import io.zeebe.engine.processor.CommandProcessor;
import io.zeebe.engine.processor.TypedRecord;
import io.zeebe.engine.state.instance.JobState;
import io.zeebe.engine.state.instance.JobState.State;
import io.zeebe.protocol.impl.record.value.job.JobRecord;
import io.zeebe.protocol.record.RejectionType;
import io.zeebe.protocol.record.intent.JobIntent;

public final class FailProcessor implements CommandProcessor<JobRecord> {

  private static final String JOB_NOT_FOUND_MESSAGE =
      "Expected to fail job with key '%d', but it does not exist";

  private static final String INVALID_JOB_STATE_MESSAGE =
      "Expected to fail job with key '%d', but it is in state '%s'";

  private final JobState state;

  public FailProcessor(final JobState state) {
    this.state = state;
  }

  @Override
  public boolean onCommand(
      final TypedRecord<JobRecord> command, final CommandControl<JobRecord> commandControl) {
    final long key = command.getKey();
    final JobState.State jobState = state.getState(key);

    if (jobState == State.ACTIVATED) {
      final JobRecord failedJob = state.getJob(key);
      failedJob.setRetries(command.getValue().getRetries());
      failedJob.setErrorMessage(command.getValue().getErrorMessageBuffer());
      state.fail(key, failedJob);

      commandControl.accept(JobIntent.FAILED, failedJob);

    } else if (jobState == State.NOT_FOUND) {
      commandControl.reject(RejectionType.NOT_FOUND, String.format(JOB_NOT_FOUND_MESSAGE, key));

    } else {
      commandControl.reject(
          RejectionType.INVALID_STATE, String.format(INVALID_JOB_STATE_MESSAGE, key, jobState));
    }
    return true;
  }
}
