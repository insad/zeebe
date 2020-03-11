/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.state;

import io.zeebe.db.ColumnFamily;
import io.zeebe.db.DbContext;
import io.zeebe.db.ZeebeDb;
import io.zeebe.db.impl.DbLong;
import io.zeebe.db.impl.DbString;

public final class NextValueManager {

  private static final int INITIAL_VALUE = 0;

  private final long initialValue;

  private final ColumnFamily<DbString, DbLong> nextValueColumnFamily;
  private final DbString nextValueKey;
  private final DbLong nextValue;

  public NextValueManager(
      final ZeebeDb<ZbColumnFamilies> zeebeDb,
      final DbContext dbContext,
      final ZbColumnFamilies columnFamily) {
    this(INITIAL_VALUE, zeebeDb, dbContext, columnFamily);
  }

  public NextValueManager(
      final long initialValue,
      final ZeebeDb<ZbColumnFamilies> zeebeDb,
      final DbContext dbContext,
      final ZbColumnFamilies columnFamily) {
    this.initialValue = initialValue;

    nextValueKey = new DbString();
    nextValue = new DbLong();
    nextValueColumnFamily =
        zeebeDb.createColumnFamily(columnFamily, dbContext, nextValueKey, nextValue);
  }

  public long getNextValue(final String key) {
    nextValueKey.wrapString(key);

    final DbLong zbLong = nextValueColumnFamily.get(nextValueKey);

    long previousKey = initialValue;
    if (zbLong != null) {
      previousKey = zbLong.getValue();
    }

    final long nextKey = previousKey + 1;
    nextValue.wrapLong(nextKey);
    nextValueColumnFamily.put(nextValueKey, nextValue);

    return nextKey;
  }
}
