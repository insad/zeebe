/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.msgpack.query;

import org.agrona.BitUtil;

public final class MsgPackTraversalContext extends AbstractDynamicContext {

  private static final int CURRENT_ELEMENT_OFFSET = 0;
  private static final int NUM_ELEMENTS_OFFSET = BitUtil.SIZE_OF_INT;
  private static final int APPLYING_FILTER_OFFSET = BitUtil.SIZE_OF_INT * 2;
  private static final int CONTAINER_TYPE_OFFSET = BitUtil.SIZE_OF_INT * 3;

  private static final int STATIC_ELEMENT_SIZE = BitUtil.SIZE_OF_INT * 4;

  public MsgPackTraversalContext(final int maxTraversalDepth, final int dynamicContextSize) {
    super(maxTraversalDepth, STATIC_ELEMENT_SIZE, dynamicContextSize);
  }

  public int currentElement() {
    return cursorView.getInt(CURRENT_ELEMENT_OFFSET);
  }

  public void currentElement(final int newValue) {
    cursorView.putInt(CURRENT_ELEMENT_OFFSET, newValue);
  }

  public int numElements() {
    return cursorView.getInt(NUM_ELEMENTS_OFFSET);
  }

  public void numElements(final int newValue) {
    cursorView.putInt(NUM_ELEMENTS_OFFSET, newValue);
  }

  public int applyingFilter() {
    return cursorView.getInt(APPLYING_FILTER_OFFSET);
  }

  public void applyingFilter(final int newValue) {
    cursorView.putInt(APPLYING_FILTER_OFFSET, newValue);
  }

  public boolean isMap() {
    return cursorView.getInt(CONTAINER_TYPE_OFFSET) == 0;
  }

  public void setIsMap(final boolean isMap) {
    cursorView.putInt(CONTAINER_TYPE_OFFSET, isMap ? 0 : 1);
  }
}
