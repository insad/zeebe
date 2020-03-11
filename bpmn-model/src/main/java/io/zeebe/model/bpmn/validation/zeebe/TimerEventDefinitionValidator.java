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
package io.zeebe.model.bpmn.validation.zeebe;

import io.zeebe.model.bpmn.instance.TimeCycle;
import io.zeebe.model.bpmn.instance.TimeDate;
import io.zeebe.model.bpmn.instance.TimeDuration;
import io.zeebe.model.bpmn.instance.TimerEventDefinition;
import io.zeebe.model.bpmn.util.time.Interval;
import io.zeebe.model.bpmn.util.time.RepeatingInterval;
import io.zeebe.model.bpmn.util.time.TimeDateTimer;
import java.time.format.DateTimeParseException;
import org.camunda.bpm.model.xml.validation.ModelElementValidator;
import org.camunda.bpm.model.xml.validation.ValidationResultCollector;

public class TimerEventDefinitionValidator implements ModelElementValidator<TimerEventDefinition> {
  @Override
  public Class<TimerEventDefinition> getElementType() {
    return TimerEventDefinition.class;
  }

  @Override
  public void validate(
      final TimerEventDefinition element,
      final ValidationResultCollector validationResultCollector) {
    final TimeDuration timeDuration = element.getTimeDuration();
    final TimeCycle timeCycle = element.getTimeCycle();
    final TimeDate timeDate = element.getTimeDate();
    int definitionsCount = 0;

    if (timeDate != null) {

      validateTimeDate(element.getTimeDate(), validationResultCollector);
      definitionsCount++;
    }

    if (timeDuration != null) {
      validateTimeDuration(validationResultCollector, timeDuration);
      definitionsCount++;
    }

    if (timeCycle != null) {
      validateTimeCycle(validationResultCollector, timeCycle);
      definitionsCount++;
    }

    if (definitionsCount != 1) {
      validationResultCollector.addError(
          0, "Must be exactly one type of timer: timeDuration, timeDate or timeCycle");
    }
  }

  private void validateTimeDate(
      final TimeDate timeDate, final ValidationResultCollector validationResultCollector) {
    try {
      TimeDateTimer.parse(timeDate.getTextContent());
    } catch (final DateTimeParseException e) {
      validationResultCollector.addError(0, "Time date is invalid");
    }
  }

  private void validateTimeCycle(
      final ValidationResultCollector validationResultCollector, final TimeCycle timeCycle) {
    try {
      RepeatingInterval.parse(timeCycle.getTextContent());
    } catch (final DateTimeParseException e) {
      validationResultCollector.addError(0, "Time cycle is invalid");
    }
  }

  private void validateTimeDuration(
      final ValidationResultCollector validationResultCollector, final TimeDuration timeDuration) {
    try {
      Interval.parse(timeDuration.getTextContent());
    } catch (final DateTimeParseException e) {
      validationResultCollector.addError(0, "Time duration is invalid");
    }
  }
}
