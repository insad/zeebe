/*
 * Copyright © 2017 camunda services GmbH (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.zeebe.protocol.record.value;

import io.zeebe.protocol.record.RecordValueWithVariables;
import io.zeebe.protocol.record.intent.JobIntent;
import io.zeebe.protocol.record.value.job.Headers;
import java.util.Map;

/**
 * Represents a job related event or command.
 *
 * <p>See {@link JobIntent} for intents.
 */
public interface JobRecordValue extends RecordValueWithVariables {
  /** @return the type of the job */
  String getType();

  /**
   * @return broker-defined headers associated with this job. For example, if this job is created in
   *     the context of workflow instance, the header provide context information on which activity
   *     is executed, etc.
   */
  Headers getHeaders();

  /** @return user-defined headers associated with this job */
  Map<String, String> getCustomHeaders();

  /** @return the assigned worker to complete the job */
  String getWorker();

  /** @return remaining retries */
  int getRetries();

  /**
   * @return the unix timestamp until when the job is exclusively assigned to this worker (time unit
   *     is milliseconds since unix epoch). If the deadline is exceeded, it can happen that the job
   *     is handed to another worker and the work is performed twice. If this property is not set it
   *     will return '-1'.
   */
  long getDeadline();

  /** @return the job worker error message if the job is failed */
  String getErrorMessage();
}
