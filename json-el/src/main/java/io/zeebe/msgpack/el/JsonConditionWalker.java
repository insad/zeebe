/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.msgpack.el;

public final class JsonConditionWalker {

  public static void walk(final JsonCondition condition, final JsonConditionVisitor visitor) {
    if (condition instanceof Comparison) {
      visitComparison((Comparison) condition, visitor);
    } else if (condition instanceof Operator) {
      final Operator operator = (Operator) condition;

      walk(operator.x(), visitor);
      walk(operator.y(), visitor);
    } else {
      throw new RuntimeException(String.format("Illegal condition: %s", condition));
    }
  }

  private static void visitComparison(
      final Comparison comparison, final JsonConditionVisitor visitor) {
    visitor.visitObject(comparison.x());
    visitor.visitObject(comparison.y());
  }
}
