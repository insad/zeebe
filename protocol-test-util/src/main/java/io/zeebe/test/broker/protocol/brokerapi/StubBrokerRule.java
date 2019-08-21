/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.test.broker.protocol.brokerapi;

import static io.zeebe.protocol.Protocol.DEPLOYMENT_PARTITION;

import io.zeebe.protocol.Protocol;
import io.zeebe.protocol.record.ValueType;
import io.zeebe.protocol.record.intent.Intent;
import io.zeebe.test.broker.protocol.MsgPackHelper;
import io.zeebe.test.broker.protocol.brokerapi.data.Topology;
import io.zeebe.transport.ServerTransport;
import io.zeebe.transport.SocketAddress;
import io.zeebe.transport.Transports;
import io.zeebe.transport.backpressure.NoLimitsLimiter;
import io.zeebe.transport.backpressure.RequestLimiter;
import io.zeebe.transport.impl.util.SocketUtil;
import io.zeebe.util.sched.ActorScheduler;
import io.zeebe.util.sched.clock.ControlledActorClock;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import org.junit.rules.ExternalResource;

public class StubBrokerRule extends ExternalResource {
  public static final int TEST_PARTITION_ID = DEPLOYMENT_PARTITION;
  protected final int nodeId;
  protected final SocketAddress socketAddress;

  protected ActorScheduler scheduler;
  protected ServerTransport transport;
  protected StubResponseChannelHandler channelHandler;
  protected MsgPackHelper msgPackHelper;
  protected AtomicReference<Topology> currentTopology = new AtomicReference<>();

  private final ControlledActorClock clock = new ControlledActorClock();
  private final int partitionCount;
  private final RequestLimiter limiter;

  public StubBrokerRule() {
    this(0);
  }

  public StubBrokerRule(final int nodeId) {
    this(nodeId, 1);
  }

  private StubBrokerRule(final int nodeId, final int partitionCount) {
    this.nodeId = nodeId;
    this.socketAddress = SocketUtil.getNextAddress();
    this.partitionCount = partitionCount;
    this.limiter = new NoLimitsLimiter();
  }

  @Override
  protected void before() {
    msgPackHelper = new MsgPackHelper();

    final int numThreads = 2;
    scheduler =
        ActorScheduler.newActorScheduler()
            .setCpuBoundActorThreadCount(numThreads)
            .setActorClock(clock)
            .build();

    scheduler.start();

    channelHandler = new StubResponseChannelHandler(msgPackHelper);

    final Topology topology = new Topology();
    topology.addLeader(nodeId, socketAddress, Protocol.DEPLOYMENT_PARTITION);

    for (int i = TEST_PARTITION_ID; i < TEST_PARTITION_ID + partitionCount; i++) {
      topology.addLeader(nodeId, socketAddress, i);
    }

    currentTopology.set(topology);
    bindTransport();
  }

  @Override
  protected void after() {
    if (transport != null) {
      closeTransport();
    }
    if (scheduler != null) {
      scheduler.stop();
    }
  }

  public void interruptAllServerChannels() {
    transport.interruptAllChannels();
  }

  public void closeTransport() {
    if (transport != null) {
      transport.close();
      transport = null;
    } else {
      throw new RuntimeException("transport not open");
    }
  }

  public void bindTransport() {
    if (transport == null) {
      transport =
          Transports.newServerTransport()
              .bindAddress(socketAddress.toInetSocketAddress())
              .scheduler(scheduler)
              .build(null, channelHandler, limiter);
    } else {
      throw new RuntimeException("transport already open");
    }
  }

  public ServerTransport getTransport() {
    return transport;
  }

  public ExecuteCommandResponseTypeBuilder onExecuteCommandRequest() {
    return onExecuteCommandRequest((r) -> true);
  }

  public ExecuteCommandResponseTypeBuilder onExecuteCommandRequest(
      final Predicate<ExecuteCommandRequest> activationFunction) {
    return new ExecuteCommandResponseTypeBuilder(
        channelHandler::addExecuteCommandRequestStub, activationFunction, msgPackHelper);
  }

  public ExecuteCommandResponseTypeBuilder onExecuteCommandRequest(
      final ValueType eventType, final Intent intent) {
    return onExecuteCommandRequest(ecr -> ecr.valueType() == eventType && ecr.intent() == intent);
  }

  public ExecuteCommandResponseTypeBuilder onExecuteCommandRequest(
      final int partitionId, final ValueType valueType, final Intent intent) {
    return onExecuteCommandRequest(
        ecr ->
            ecr.partitionId() == partitionId
                && ecr.valueType() == valueType
                && ecr.intent() == intent);
  }

  public List<ExecuteCommandRequest> getReceivedCommandRequests() {
    return channelHandler.getReceivedCommandRequests();
  }

  public List<Object> getAllReceivedRequests() {
    return channelHandler.getAllReceivedRequests();
  }

  public void addPartition(final int partition) {
    final Topology newTopology = new Topology(currentTopology.get());

    newTopology.addLeader(nodeId, socketAddress, partition);
    currentTopology.set(newTopology);
  }

  public void clearTopology() {
    currentTopology.set(new Topology());
  }

  public JobStubs jobs() {
    return new JobStubs(this);
  }

  public SocketAddress getSocketAddress() {
    return socketAddress;
  }

  public int getNodeId() {
    return nodeId;
  }

  public ControlledActorClock getClock() {
    return clock;
  }
}
