/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.broker.system.configuration;

import io.zeebe.util.Environment;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class DataCfg implements ConfigurationEntry {
  public static final String DEFAULT_DIRECTORY = "data";

  // Hint: do not use Collections.singletonList as this does not support replaceAll
  private List<String> directories = Arrays.asList(DEFAULT_DIRECTORY);

  private String logSegmentSize = "512M";

  private String snapshotPeriod = "15m";

  private String raftSegmentSize;

  private int maxSnapshots = 3;

  @Override
  public void init(
      final BrokerCfg globalConfig, final String brokerBase, final Environment environment) {
    raftSegmentSize = Optional.ofNullable(raftSegmentSize).orElse(logSegmentSize);

    applyEnvironment(environment);
    directories.replaceAll(d -> ConfigurationUtil.toAbsolutePath(d, brokerBase));
  }

  private void applyEnvironment(final Environment environment) {
    environment.getList(EnvironmentConstants.ENV_DIRECTORIES).ifPresent(v -> directories = v);
  }

  public List<String> getDirectories() {
    return directories;
  }

  public void setDirectories(final List<String> directories) {
    this.directories = directories;
  }

  public String getLogSegmentSize() {
    return logSegmentSize;
  }

  public void setLogSegmentSize(final String logSegmentSize) {
    this.logSegmentSize = logSegmentSize;
  }

  public String getSnapshotPeriod() {
    return snapshotPeriod;
  }

  public void setSnapshotPeriod(final String snapshotPeriod) {
    this.snapshotPeriod = snapshotPeriod;
  }

  public int getMaxSnapshots() {
    return maxSnapshots;
  }

  public void setMaxSnapshots(final int maxSnapshots) {
    this.maxSnapshots = maxSnapshots;
  }

  public String getRaftSegmentSize() {
    return raftSegmentSize;
  }

  public void setRaftSegmentSize(final String raftSegmentSize) {
    this.raftSegmentSize = raftSegmentSize;
  }

  @Override
  public String toString() {
    return "DataCfg{"
        + "directories="
        + directories
        + ", logSegmentSize='"
        + logSegmentSize
        + '\''
        + ", snapshotPeriod='"
        + snapshotPeriod
        + '\''
        + ", raftSegmentSize='"
        + raftSegmentSize
        + '\''
        + ", maxSnapshots="
        + maxSnapshots
        + '}';
  }
}
