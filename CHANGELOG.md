<a name="0.23.0-alpha1"></a>

# Release: 0.23.0-alpha1
## Enhancements
### Broker
* Throw an error from an end event ([#3510](https://github.com/zeebe-io/zeebe/issues/3510))
* Raise an incident if an error is not caught ([#3503](https://github.com/zeebe-io/zeebe/issues/3503))
* Catch an error from a called workflow instance ([#3502](https://github.com/zeebe-io/zeebe/issues/3502))

### Go Client
* Allow context in Go client API ([#3530](https://github.com/zeebe-io/zeebe/issues/3530))
### Misc
* Add broker version info to Topology cmd in clients ([#3733](https://github.com/zeebe-io/zeebe/issues/3733))
* Add broker version to topology ([#3732](https://github.com/zeebe-io/zeebe/issues/3732))
* Get gateway version in zbctl ([#3701](https://github.com/zeebe-io/zeebe/issues/3701))
* Get gateway version in Java client ([#3692](https://github.com/zeebe-io/zeebe/issues/3692))
* Get gateway version in Go client ([#3691](https://github.com/zeebe-io/zeebe/issues/3691))
* Broker version via API ([#2981](https://github.com/zeebe-io/zeebe/issues/2981))
## Bug Fixes
### Broker
* Race condition with snapshot replication ([#3717](https://github.com/zeebe-io/zeebe/issues/3717))
* TopologyManager gets two leaders for same partition at same term. ([#3697](https://github.com/zeebe-io/zeebe/issues/3697))
* Inconsistent log positions ([#3651](https://github.com/zeebe-io/zeebe/issues/3651))
### Go Client
* zbctl build does not contain version information ([#3647](https://github.com/zeebe-io/zeebe/issues/3647))
### Misc
* Out of direct memory in the Engine ([#3686](https://github.com/zeebe-io/zeebe/issues/3686))
* Subscriptions of event subprocesses are not closed when one interrupting event subprocess is triggered ([#3681](https://github.com/zeebe-io/zeebe/issues/3681))
* Workflow instance is stuck when an interrupting event subprocess is triggered ([#3680](https://github.com/zeebe-io/zeebe/issues/3680))
* No incident is raising if an error is not caught and a matching error event subprocess exists ([#3678](https://github.com/zeebe-io/zeebe/issues/3678))
* Error is not caught by an error event subprocess inside a multi-instance embedded subprocess ([#3671](https://github.com/zeebe-io/zeebe/issues/3671))
* Possible OOM with embedded Gateway and high load ([#3653](https://github.com/zeebe-io/zeebe/issues/3653))
* Output Parameters with result dict ([#3621](https://github.com/zeebe-io/zeebe/issues/3621))
## Documentation
* Document GatewayVersion RPC request ([#3702](https://github.com/zeebe-io/zeebe/issues/3702))
## Merged Pull Requests
* Add RocksDB snapshot metrics ([#3447](https://github.com/zeebe-io/zeebe/issues/3447))
* Add content-type to OAuth request ([#3781](https://github.com/zeebe-io/zeebe/pull/3781))
* feat(clients/java): removed setTimeout(long) ([#3778](https://github.com/zeebe-io/zeebe/pull/3778))
* chore(deps): update module testcontainers/testcontainers-go to v0.1.0 ([#3774](https://github.com/zeebe-io/zeebe/pull/3774))
* chore(deps): update version.protobuf to v3.11.3 ([#3773](https://github.com/zeebe-io/zeebe/pull/3773))
* chore(README): correct docs for new users links ([#3772](https://github.com/zeebe-io/zeebe/pull/3772))
* chore(deps): update golang.org/x/net commit hash to 1617124 ([#3771](https://github.com/zeebe-io/zeebe/pull/3771))
* chore(deps): update dependency com.github.tomakehurst:wiremock-jre8 to v2.26.0 ([#3769](https://github.com/zeebe-io/zeebe/pull/3769))
* feat(broker): resolve incident for unhandled error ([#3766](https://github.com/zeebe-io/zeebe/pull/3766))
* chore(deps): update module go-ozzo/ozzo-validation/v3 to v4 ([#3762](https://github.com/zeebe-io/zeebe/pull/3762))
* chore(deps): update module golang/protobuf to v1.3.3 ([#3754](https://github.com/zeebe-io/zeebe/pull/3754))
* chore(deps): update version.grpc to v1.27.0 ([#3753](https://github.com/zeebe-io/zeebe/pull/3753))
* chore(deps): update dependency com.fasterxml.jackson:jackson-bom to v2.10.2.20200130 ([#3750](https://github.com/zeebe-io/zeebe/pull/3750))
* chore(deps): update dependency org.assertj:assertj-core to v3.15.0 ([#3749](https://github.com/zeebe-io/zeebe/pull/3749))
* chore(deps): update module google.golang.org/grpc to v1.27.0 ([#3748](https://github.com/zeebe-io/zeebe/pull/3748))
* feat(broker): support error end events ([#3744](https://github.com/zeebe-io/zeebe/pull/3744))
* docs(clients): add section on other clients ([#3742](https://github.com/zeebe-io/zeebe/pull/3742))
* Expose broker version in topology cmd ([#3740](https://github.com/zeebe-io/zeebe/pull/3740))
* chore(broker): distribute broker version in topology ([#3739](https://github.com/zeebe-io/zeebe/pull/3739))
* chore(monitor): adjust pod variables to helm usage ([#3737](https://github.com/zeebe-io/zeebe/pull/3737))
* fix(broker): merge variable on output mapping ([#3736](https://github.com/zeebe-io/zeebe/pull/3736))
* Refactor gateway version command ([#3735](https://github.com/zeebe-io/zeebe/pull/3735))
* Fix out of direct memory issue on running engine tests  ([#3731](https://github.com/zeebe-io/zeebe/pull/3731))
* chore(deps): update version.prometheus to v0.8.1 ([#3730](https://github.com/zeebe-io/zeebe/pull/3730))
* chore(deps): update module yaml to v2.2.8 ([#3729](https://github.com/zeebe-io/zeebe/pull/3729))
* chore(deps): update dependency org.testcontainers:testcontainers to v1.12.5 ([#3728](https://github.com/zeebe-io/zeebe/pull/3728))
* Engine close resources ([#3727](https://github.com/zeebe-io/zeebe/pull/3727))
* chore(deps): update module golang/mock to v1.4.0 ([#3725](https://github.com/zeebe-io/zeebe/pull/3725))
* chore(deps): update dependency org.rocksdb:rocksdbjni to v6.5.3 ([#3724](https://github.com/zeebe-io/zeebe/pull/3724))
* chore(deps): update version.sbe to v1.16.1 ([#3723](https://github.com/zeebe-io/zeebe/pull/3723))
* chore(deps): update dependency org.agrona:agrona to v1.3.0 ([#3722](https://github.com/zeebe-io/zeebe/pull/3722))
* Add gateway version to zbctl ([#3720](https://github.com/zeebe-io/zeebe/pull/3720))
* fix(broker): fixing interrupting event subprocesses ([#3719](https://github.com/zeebe-io/zeebe/pull/3719))
* chore(broker): replicate empty files ([#3718](https://github.com/zeebe-io/zeebe/pull/3718))
* chore(broker): use node id on stream processor ([#3716](https://github.com/zeebe-io/zeebe/pull/3716))
* chore(broker): use actor name on LogStreamDeletionService ([#3715](https://github.com/zeebe-io/zeebe/pull/3715))
* Remove onOpen lifecycle method ([#3714](https://github.com/zeebe-io/zeebe/pull/3714))
* fix(broker): raise incident if error catch event is interrupted ([#3713](https://github.com/zeebe-io/zeebe/pull/3713))
* chore(broker): suppress position supplier log in snapshotstore ([#3712](https://github.com/zeebe-io/zeebe/pull/3712))
* chore(deps): update dependency net.alchim31.maven:scala-maven-plugin to v4.3.1 ([#3710](https://github.com/zeebe-io/zeebe/pull/3710))
* chore(deps): update dependency org.apache.httpcomponents:httpclient to v4.5.11 ([#3709](https://github.com/zeebe-io/zeebe/pull/3709))
* chore(broker): get role and term on raft role change ([#3708](https://github.com/zeebe-io/zeebe/pull/3708))
* Add gateway version cmd in Java client ([#3707](https://github.com/zeebe-io/zeebe/pull/3707))
* feat(broker): add gateway version command ([#3706](https://github.com/zeebe-io/zeebe/pull/3706))
* chore(gateway): return DEADLINE_EXCEEDED on transport timeout ([#3700](https://github.com/zeebe-io/zeebe/pull/3700))
* fix(broker): catch error inside multi-instance subprocess ([#3698](https://github.com/zeebe-io/zeebe/pull/3698))
* chore(qa): prevent false positive exceptions on ClusteringRule#after ([#3696](https://github.com/zeebe-io/zeebe/pull/3696))
* Get gateway version in Go client ([#3695](https://github.com/zeebe-io/zeebe/pull/3695))
* Don't use writer on reprocessing ([#3693](https://github.com/zeebe-io/zeebe/pull/3693))
* fix(logstreams): reset writer on reprocessing ([#3690](https://github.com/zeebe-io/zeebe/pull/3690))
* chore(monitor): add Grafana dashboard ([#3689](https://github.com/zeebe-io/zeebe/pull/3689))
* chore(broker): adds snapshot metrics ([#3668](https://github.com/zeebe-io/zeebe/pull/3668))
* Fix inconsistent position creation ([#3660](https://github.com/zeebe-io/zeebe/pull/3660))
* fix(transport): cancel timer after response ([#3659](https://github.com/zeebe-io/zeebe/pull/3659))
* chore(clients/java): enforce API stability in Java code ([#3658](https://github.com/zeebe-io/zeebe/pull/3658))
* chore(deps): update golang.org/x/net commit hash to 6afb519 ([#3657](https://github.com/zeebe-io/zeebe/pull/3657))
* feat(broker): catch error event from child instance ([#3650](https://github.com/zeebe-io/zeebe/pull/3650))
* Check backwards compatibility in Go client ([#3649](https://github.com/zeebe-io/zeebe/pull/3649))
* chore(clients/go): fix set zbctl version and commit during build ([#3648](https://github.com/zeebe-io/zeebe/pull/3648))
* chore(deps): update dependency io.netty:netty-bom to v4.1.45.final ([#3646](https://github.com/zeebe-io/zeebe/pull/3646))
* docs(bpmn-workflows): add error event section ([#3644](https://github.com/zeebe-io/zeebe/pull/3644))
* chore(deps): update version.httpcomponents to v4.4.13 ([#3643](https://github.com/zeebe-io/zeebe/pull/3643))
* chore(engine): clean up timers after each test ([#3642](https://github.com/zeebe-io/zeebe/pull/3642))
* feat(clients/go): require context to send commands ([#3638](https://github.com/zeebe-io/zeebe/pull/3638))
* chore(deps): update version.sbe to v1.16.0 ([#3636](https://github.com/zeebe-io/zeebe/pull/3636))
* chore(deps): update dependency org.ow2.asm:asm to v7.3.1 ([#3635](https://github.com/zeebe-io/zeebe/pull/3635))
* Uniform actor names ([#3634](https://github.com/zeebe-io/zeebe/pull/3634))
* chore(transport): do not send request when timeout is already reached ([#3629](https://github.com/zeebe-io/zeebe/pull/3629))
* chore(deps): update dependency com.google.guava:guava to v28.2-jre ([#3627](https://github.com/zeebe-io/zeebe/pull/3627))
* chore(deps): update dependency org.agrona:agrona to v1.2.0 ([#3625](https://github.com/zeebe-io/zeebe/pull/3625))
* test(transport): fix flaky test ([#3620](https://github.com/zeebe-io/zeebe/pull/3620))
* add a java sample code for create workflow with await result ([#3616](https://github.com/zeebe-io/zeebe/pull/3616))
* chore(deps): update module google/go-cmp to v0.4.0 ([#3611](https://github.com/zeebe-io/zeebe/pull/3611))

<a name="0.22.1"></a>
# Release: 0.22.1
## Fixes
* Out of direct memory in the Engine ([#3686](https://github.com/zeebe-io/zeebe/issues/3686))
* Possible OOM with embedded Gateway and high load ([#3653](https://github.com/zeebe-io/zeebe/issues/3653))
* Inconsistent log positions ([#3651](https://github.com/zeebe-io/zeebe/issues/3651))
* zbctl build does not contain version information ([#3647](https://github.com/zeebe-io/zeebe/issues/3647))
* Append Backpressure metrics are broken ([#3626](https://github.com/zeebe-io/zeebe/issues/3626))

## Merged Pull Requests
* [BACKPORT] Don't use writer on reprocessing ([#3694](https://github.com/zeebe-io/zeebe/pull/3694))
* Don't use writer on reprocessing ([#3693](https://github.com/zeebe-io/zeebe/pull/3693))
* [BACKPORT] Fix inconsistent position creation ([#3685](https://github.com/zeebe-io/zeebe/pull/3685))
* [BACKPORT] chore(clients/go): fix set zbctl version and commit during build ([#3684](https://github.com/zeebe-io/zeebe/pull/3684))
* [BACKPORT] Uniform actor names ([#3683](https://github.com/zeebe-io/zeebe/pull/3683))
* [BACKPORT] fix(transport): cancel timer after response ([#3682](https://github.com/zeebe-io/zeebe/pull/3682))
* Fix inconsistent position creation ([#3660](https://github.com/zeebe-io/zeebe/pull/3660))
* fix(transport): cancel timer after response ([#3659](https://github.com/zeebe-io/zeebe/pull/3659))
* chore(clients/go): fix set zbctl version and commit during build ([#3648](https://github.com/zeebe-io/zeebe/pull/3648))
* Uniform actor names ([#3634](https://github.com/zeebe-io/zeebe/pull/3634))

<a name="0.22.0"></a>
# Release: 0.22.0
## Enhancements
### Broker
* Raise an incident if an error is not caught ([#3503](https://github.com/zeebe-io/zeebe/issues/3503))
* Catch an error on an event subprocess ([#3498](https://github.com/zeebe-io/zeebe/issues/3498))
* Catch an error on a boundary event ([#3497](https://github.com/zeebe-io/zeebe/issues/3497))
* Use Raft directly ([#3169](https://github.com/zeebe-io/zeebe/issues/3169))
### Java Client
* I can throw a job error from the Java client ([#3506](https://github.com/zeebe-io/zeebe/issues/3506))
* Enable grpc interceptors in java client ([#3414](https://github.com/zeebe-io/zeebe/issues/3414))
* Enable gRPC keepalive ([#3368](https://github.com/zeebe-io/zeebe/issues/3368))
### Go Client
* I can throw a job error from zbctl ([#3508](https://github.com/zeebe-io/zeebe/issues/3508))
* I can throw a job error from the Go client ([#3507](https://github.com/zeebe-io/zeebe/issues/3507))
* Enable gRPC keepalive ([#3368](https://github.com/zeebe-io/zeebe/issues/3368))
## Bug Fixes
### Broker
* Unexpected non-empty log failed to read the last block ([#3543](https://github.com/zeebe-io/zeebe/issues/3543))
* Possible SIGSEG on closing partition ([#3523](https://github.com/zeebe-io/zeebe/issues/3523))
* io.zeebe.broker.workflow.message.MessageMappingTest flaky ([#2394](https://github.com/zeebe-io/zeebe/issues/2394))
* Message variables are not merged if the message correlates to an event subprocess ([#3552](https://github.com/zeebe-io/zeebe/issues/3552))
* NPE when creating a new workflow instance and no correlation key is defined ([#3551](https://github.com/zeebe-io/zeebe/issues/3551))
* Missing timeouts in clients ([#3460](https://github.com/zeebe-io/zeebe/issues/3460))
## Documentation
* Update Operate enterprise availability ([#3563](https://github.com/zeebe-io/zeebe/issues/3563))
* Add note to Message Correlation on Subscription  ([#2688](https://github.com/zeebe-io/zeebe/issues/2688))
## Merged Pull Requests
* chore(broker): introduce configurable step timeout ([#3619](https://github.com/zeebe-io/zeebe/pull/3619))
* chore(gateway): add throw error request/response handler ([#3617](https://github.com/zeebe-io/zeebe/pull/3617))
* fix(broker): avoid unnecessary exporter director starting ([#3615](https://github.com/zeebe-io/zeebe/pull/3615))
* fix(transport): fix response race condition ([#3614](https://github.com/zeebe-io/zeebe/pull/3614))
* chore(broker): add correlationKey to correlate workflow instance command ([#3613](https://github.com/zeebe-io/zeebe/pull/3613))
* Bring internal socket back ([#3610](https://github.com/zeebe-io/zeebe/pull/3610))
* chore(engine): merge message variables in event subprocess ([#3607](https://github.com/zeebe-io/zeebe/pull/3607))
* chore(dispatcher): remove unused code ([#3604](https://github.com/zeebe-io/zeebe/pull/3604))
* invalidate message event subprocess with no correlation key ([#3602](https://github.com/zeebe-io/zeebe/pull/3602))
* feat(broker): raise incident if an error is not caught ([#3598](https://github.com/zeebe-io/zeebe/pull/3598))
* chore(deps): update dependency com.fasterxml.jackson:jackson-bom to v2.10.2 ([#3597](https://github.com/zeebe-io/zeebe/pull/3597))
* chore(deps): update dependency commons-codec:commons-codec to v1.14 ([#3596](https://github.com/zeebe-io/zeebe/pull/3596))
* chore(deps): update dependency junit:junit to v4.13 ([#3594](https://github.com/zeebe-io/zeebe/pull/3594))
* chore(deps): update dependency junit:junit to v4.13 ([#3593](https://github.com/zeebe-io/zeebe/pull/3593))
* chore(deps): update dependency org.rocksdb:rocksdbjni to v6.5.2 ([#3592](https://github.com/zeebe-io/zeebe/pull/3592))
* chore(client): ZeebeFuture extens CompletionStage ([#3589](https://github.com/zeebe-io/zeebe/pull/3589))
* feat(broker): trigger error event subprocess ([#3582](https://github.com/zeebe-io/zeebe/pull/3582))
* chore(deps): update module testcontainers/testcontainers-go to v0.0.10 ([#3581](https://github.com/zeebe-io/zeebe/pull/3581))
* docs(clients/java): improve description of correlation key ([#3579](https://github.com/zeebe-io/zeebe/pull/3579))
* chore(logstreams): refactor LogStreamBuilder ([#3578](https://github.com/zeebe-io/zeebe/pull/3578))
* chore(deps): update version.elasticsearch to v6.8.6 ([#3576](https://github.com/zeebe-io/zeebe/pull/3576))
* chore(deps): update docker.elastic.co/kibana/kibana-oss docker tag to v6.8.6 ([#3575](https://github.com/zeebe-io/zeebe/pull/3575))
* chore(deps): update docker.elastic.co/elasticsearch/elasticsearch-oss docker tag to v6.8.6 ([#3574](https://github.com/zeebe-io/zeebe/pull/3574))
* chore(deps): update dependency io.netty:netty-bom to v4.1.44.final ([#3572](https://github.com/zeebe-io/zeebe/pull/3572))
* fix(logstreams): fixes detection of empty log on seekToEnd ([#3571](https://github.com/zeebe-io/zeebe/pull/3571))
* chore(deps): update version.grpc to v1.26.0 ([#3570](https://github.com/zeebe-io/zeebe/pull/3570))
* chore(deps): update module google.golang.org/grpc to v1.26.0 ([#3567](https://github.com/zeebe-io/zeebe/pull/3567))
* Fix CI build ([#3565](https://github.com/zeebe-io/zeebe/pull/3565))
* docs(Operate User Guide): Update Operate enterprise availability ([#3564](https://github.com/zeebe-io/zeebe/pull/3564))
* chore(deps): update dependency org.slf4j:slf4j-api to v1.7.30 ([#3561](https://github.com/zeebe-io/zeebe/pull/3561))
* chore(deps): update dependency org.slf4j:slf4j-api to v1.7.30 ([#3560](https://github.com/zeebe-io/zeebe/pull/3560))
* chore(qa): adds test to ensure positions always increase even with restarts ([#3558](https://github.com/zeebe-io/zeebe/pull/3558))
* chore(ci): build and test Go in parallel stage ([#3555](https://github.com/zeebe-io/zeebe/pull/3555))
* chore(deps): update dependency org.mockito:mockito-core to v3.2.4 ([#3554](https://github.com/zeebe-io/zeebe/pull/3554))
* chore(engine): improve MessageMappingTest stability ([#3553](https://github.com/zeebe-io/zeebe/pull/3553))
* docs(bpmn-workflows): remove mention of processIdExpression ([#3550](https://github.com/zeebe-io/zeebe/pull/3550))
* chore(deps): update version.log4j to v2.13.0 ([#3549](https://github.com/zeebe-io/zeebe/pull/3549))
* feat(clients/go): add timeouts to OAuth requests ([#3548](https://github.com/zeebe-io/zeebe/pull/3548))
* Replace transport implementation ([#3547](https://github.com/zeebe-io/zeebe/pull/3547))
* feat(broker): support error boundary event ([#3540](https://github.com/zeebe-io/zeebe/pull/3540))
* Use final on classes where possible ([#3539](https://github.com/zeebe-io/zeebe/pull/3539))
* chore(logstreams): close completes on actor closed ([#3538](https://github.com/zeebe-io/zeebe/pull/3538))
* chore(dispatcher): remove pipeline mode ([#3533](https://github.com/zeebe-io/zeebe/pull/3533))
* chore(project): final everywhere ([#3529](https://github.com/zeebe-io/zeebe/pull/3529))
* fix(broker): avoid SIGSEG on close ([#3528](https://github.com/zeebe-io/zeebe/pull/3528))
* feat(clients/go): add throw error to zbctl ([#3526](https://github.com/zeebe-io/zeebe/pull/3526))
* Add throw error command in Java client ([#3524](https://github.com/zeebe-io/zeebe/pull/3524))
* chore(logstreams): zero-copy LogStreamReaderImpl ([#3522](https://github.com/zeebe-io/zeebe/pull/3522))
* Adds throw error command in Go client ([#3517](https://github.com/zeebe-io/zeebe/pull/3517))
* Remove service container ([#3513](https://github.com/zeebe-io/zeebe/pull/3513))
* Make renovate bot ignore docker dependency ([#3512](https://github.com/zeebe-io/zeebe/pull/3512))
* chore(clients/go): don't fail zbctl test if dist is missing ([#3509](https://github.com/zeebe-io/zeebe/pull/3509))
* chore(deps): update golang.org/x/net commit hash to c0dbc17 ([#3495](https://github.com/zeebe-io/zeebe/pull/3495))
* chore(project): customize Go linters ([#3494](https://github.com/zeebe-io/zeebe/pull/3494))
* chore(deps): update golang.org/x/net commit hash to 1ddd1de ([#3490](https://github.com/zeebe-io/zeebe/pull/3490))
* update message correlation documentation ([#3488](https://github.com/zeebe-io/zeebe/pull/3488))
* Support keep alive pings ([#3487](https://github.com/zeebe-io/zeebe/pull/3487))
* chore(deps): update module go-ozzo/ozzo-validation/v3 to v3.8.1 ([#3483](https://github.com/zeebe-io/zeebe/pull/3483))
* docs(Introduction): Add Modeler to 'Install' page ([#3481](https://github.com/zeebe-io/zeebe/pull/3481))
* chore(deps): update module go-ozzo/ozzo-validation/v3 to v3.8.0 ([#3479](https://github.com/zeebe-io/zeebe/pull/3479))
* chore(deps): update dependency io.netty:netty-tcnative-boringssl-static to v2.0.28.final ([#3478](https://github.com/zeebe-io/zeebe/pull/3478))
* chore(gateway): allow to set the number of max messages buffered ([#3475](https://github.com/zeebe-io/zeebe/pull/3475))
* Docs workflow creation ([#3470](https://github.com/zeebe-io/zeebe/pull/3470))
* Add zbctl integration tests ([#3462](https://github.com/zeebe-io/zeebe/pull/3462))
* feat(clients/java): enable grpc prometheus metrics ([#3416](https://github.com/zeebe-io/zeebe/pull/3416))
* feat(broker): deploy larger workflows ([#3005](https://github.com/zeebe-io/zeebe/pull/3005))


<a name="0.22.0-alpha2"></a>
# Release: 0.22.0-alpha2
## Enhancements
### Broker
* A message creates only one workflow instance per correlation-key ([#3337](https://github.com/zeebe-io/zeebe/issues/3337))
* Correlate a message only once per workflow ([#3334](https://github.com/zeebe-io/zeebe/issues/3334))
* Support workflows with multiple start events ([#3317](https://github.com/zeebe-io/zeebe/issues/3317))
* Use Raft directly ([#3169](https://github.com/zeebe-io/zeebe/issues/3169))
* Event subprocess with non-interrupting message start ([#3209](https://github.com/zeebe-io/zeebe/issues/3209))
### Java Client
* Return command key for set variables command ([#3423](https://github.com/zeebe-io/zeebe/issues/3423))
### Go Client
* Return command key for set variables command ([#3423](https://github.com/zeebe-io/zeebe/issues/3423))
## Bug Fixes
### Broker
* Restarting a broker with many segments causes broker timeout ([#3456](https://github.com/zeebe-io/zeebe/issues/3456))
* Message is correlated after TTL is reached ([#3396](https://github.com/zeebe-io/zeebe/issues/3396))
* Topology manager receives events in different order resulting in wrong leader info  ([#3364](https://github.com/zeebe-io/zeebe/issues/3364))
### Java Client
* False warning/exceptions due to race condition when closing JobWorker ([#3318](https://github.com/zeebe-io/zeebe/issues/3318))
### Go Client
* Go job worker is constantly requesting access tokens ([#3372](https://github.com/zeebe-io/zeebe/issues/3372))
### Misc
* Zeebe distribution does not contain zbctl ([#3458](https://github.com/zeebe-io/zeebe/issues/3458))
* Processing stops because sessions of the DistributedLogStreamClient are closed ([#3370](https://github.com/zeebe-io/zeebe/issues/3370))
* Snapshots are marked as valid too early ([#3348](https://github.com/zeebe-io/zeebe/issues/3348))
* Replication thread access DB and causes SIGSEG ([#3338](https://github.com/zeebe-io/zeebe/issues/3338))
* Log restoring failed due to invalid offset ([#3239](https://github.com/zeebe-io/zeebe/issues/3239))
## Documentation
* Document event subprocess ([#3363](https://github.com/zeebe-io/zeebe/issues/3363))
## Merged Pull Requests
* chore(deps): update golang.org/x/net commit hash to 5ee1b9f ([#3477](https://github.com/zeebe-io/zeebe/pull/3477))
* chore(deps): update module go-ozzo/ozzo-validation to v3.7.0 ([#3476](https://github.com/zeebe-io/zeebe/pull/3476))
* chore(deps): update version.protobuf to v3.11.1 ([#3471](https://github.com/zeebe-io/zeebe/pull/3471))
* chore(deps): update dependency com.google.errorprone:error_prone_annotations to v2.3.4 ([#3469](https://github.com/zeebe-io/zeebe/pull/3469))
* chore(broker): fix race conditions related to snapshot storage ([#3468](https://github.com/zeebe-io/zeebe/pull/3468))
* chore(dist): enable default metrics for standalone gateway ([#3467](https://github.com/zeebe-io/zeebe/pull/3467))
* chore(logstreams): remove retry mechanism ([#3465](https://github.com/zeebe-io/zeebe/pull/3465))
* fix(broker): increase start up time out ([#3464](https://github.com/zeebe-io/zeebe/pull/3464))
* chore(dist): update golang version ([#3461](https://github.com/zeebe-io/zeebe/pull/3461))
* docs(glossary): add the glossary to SUMMARY ([#3459](https://github.com/zeebe-io/zeebe/pull/3459))
* chore(deps): update dependency org.mockito:mockito-core to v3.2.0 ([#3455](https://github.com/zeebe-io/zeebe/pull/3455))
* fix(exporter): enable variable document export by default ([#3451](https://github.com/zeebe-io/zeebe/pull/3451))
* chore(deps): update dependency org.camunda.bpm.model:camunda-xml-model to v7.12.0 ([#3446](https://github.com/zeebe-io/zeebe/pull/3446))
* docs(timer): fix infinite timer example ([#3442](https://github.com/zeebe-io/zeebe/pull/3442))
* chore(deps): update version.msgpack to v0.8.20 ([#3441](https://github.com/zeebe-io/zeebe/pull/3441))
* fix(broker): don't correlate a message after its TTL is reached ([#3440](https://github.com/zeebe-io/zeebe/pull/3440))
* chore(deps): update version.protobuf to v3.11.0 ([#3437](https://github.com/zeebe-io/zeebe/pull/3437))
* chore(deps): update module golang/mock to v1.3.1 ([#3435](https://github.com/zeebe-io/zeebe/pull/3435))
* chore(deps): update docker.elastic.co/kibana/kibana-oss docker tag to v6.8.5 ([#3434](https://github.com/zeebe-io/zeebe/pull/3434))
* chore(deps): update docker.elastic.co/elasticsearch/elasticsearch-oss docker tag to v6.8.5 ([#3433](https://github.com/zeebe-io/zeebe/pull/3433))
* chore(deps): update dependency org.scala-lang:scala-library to v2.13.1 ([#3432](https://github.com/zeebe-io/zeebe/pull/3432))
* chore(deps): update dependency org.camunda.bpm.model:camunda-xml-model to v7.11.0 ([#3430](https://github.com/zeebe-io/zeebe/pull/3430))
* chore(deps): update dependency org.apache.maven.plugins:maven-enforcer-plugin to v3.0.0-m3 ([#3428](https://github.com/zeebe-io/zeebe/pull/3428))
* chore(deps): update golang.org/x/net commit hash to ef20fe5 ([#3427](https://github.com/zeebe-io/zeebe/pull/3427))
* chore(deps): bump rocksdbjni from 6.3.6 to 6.4.6 ([#3426](https://github.com/zeebe-io/zeebe/pull/3426))
* chore(deps): bump maven-enforcer-plugin from 3.0.0-M2 to 3.0.0-M3 ([#3425](https://github.com/zeebe-io/zeebe/pull/3425))
* Add key to set variables response ([#3424](https://github.com/zeebe-io/zeebe/pull/3424))
* chore(pom): update surefire and failsaife to M4 ([#3422](https://github.com/zeebe-io/zeebe/pull/3422))
* chore(deps): bump version.sbe from 1.14.1 to 1.15.0 ([#3421](https://github.com/zeebe-io/zeebe/pull/3421))
* Configure Renovate ([#3418](https://github.com/zeebe-io/zeebe/pull/3418))
* Go client interface improvements ([#3415](https://github.com/zeebe-io/zeebe/pull/3415))
* chore(Nexus cache): Use jenkins configfile instead of local settings.xml ([#3413](https://github.com/zeebe-io/zeebe/pull/3413))
* chore(ci): Fix cron trigger for chaos tests pipeline ([#3411](https://github.com/zeebe-io/zeebe/pull/3411))
* feat(broker): message creates only once instance per correlation key ([#3408](https://github.com/zeebe-io/zeebe/pull/3408))
* docs(introduction): section on nomenclature ([#3407](https://github.com/zeebe-io/zeebe/pull/3407))
* chore(deps): bump gopkg.in/yaml.v2 from 2.2.4 to 2.2.7 in /clients/go ([#3406](https://github.com/zeebe-io/zeebe/pull/3406))
* chore(deps): bump github.com/testcontainers/testcontainers-go from 0.0.8 to 0.0.9 in /clients/go ([#3405](https://github.com/zeebe-io/zeebe/pull/3405))
* test(gateway): fix flaky BrokerClientTest ([#3403](https://github.com/zeebe-io/zeebe/pull/3403))
* chore(deps): bump version.elasticsearch from 6.8.4 to 6.8.5 ([#3402](https://github.com/zeebe-io/zeebe/pull/3402))
* chore(logstreams): do not append more events until retries are success ([#3399](https://github.com/zeebe-io/zeebe/pull/3399))
* Migrate to go modules ([#3395](https://github.com/zeebe-io/zeebe/pull/3395))
* chore(deps): bump agrona from 1.0.11 to 1.1.0 ([#3394](https://github.com/zeebe-io/zeebe/pull/3394))
* chore(deps): bump version.msgpack from 0.8.16 to 0.8.19 ([#3393](https://github.com/zeebe-io/zeebe/pull/3393))
* Improve Go project layout ([#3391](https://github.com/zeebe-io/zeebe/pull/3391))
* chore(deps): bump plugin.version.surefire from 3.0.0-M3 to 3.0.0-M4 ([#3387](https://github.com/zeebe-io/zeebe/pull/3387))
* chore(deps): bump maven-failsafe-plugin from 3.0.0-M3 to 3.0.0-M4 ([#3386](https://github.com/zeebe-io/zeebe/pull/3386))
* fix(logstreams): retry append on failure ([#3385](https://github.com/zeebe-io/zeebe/pull/3385))
* Merge zbctl with the Go client ([#3384](https://github.com/zeebe-io/zeebe/pull/3384))
* docs(bpmn-workflows): allow multiple start events ([#3381](https://github.com/zeebe-io/zeebe/pull/3381))
* chore(deps): bump github.com/docker/docker from 19.03.4 to 19.03.5 in /clients/go ([#3380](https://github.com/zeebe-io/zeebe/pull/3380))
* chore(protocol): include leader term in distributed topology info ([#3375](https://github.com/zeebe-io/zeebe/pull/3375))
* docs(bpmn-workflows): document event subprocess ([#3374](https://github.com/zeebe-io/zeebe/pull/3374))
* Not refetch credentials if cache is present on second request ([#3373](https://github.com/zeebe-io/zeebe/pull/3373))
* test(engine): test variables in event subproc ([#3365](https://github.com/zeebe-io/zeebe/pull/3365))
* Fix stream processor dependencies ([#3362](https://github.com/zeebe-io/zeebe/pull/3362))
* feat(broker): correlate only once per workflow ([#3360](https://github.com/zeebe-io/zeebe/pull/3360))
* fix(broker): add null check when no exporter is configured ([#3356](https://github.com/zeebe-io/zeebe/pull/3356))
* fix(engine): pending snapshot is set after write position is received ([#3354](https://github.com/zeebe-io/zeebe/pull/3354))
* fix(broker): fix sigseg on replication thread ([#3353](https://github.com/zeebe-io/zeebe/pull/3353))
* chore(deps): bump jackson-bom from 2.10.0 to 2.10.1 ([#3350](https://github.com/zeebe-io/zeebe/pull/3350))
* chore(deps): bump google.golang.org/grpc from 1.24.0 to 1.25.1 in /clients/go ([#3349](https://github.com/zeebe-io/zeebe/pull/3349))
* Update docs to support latest mdbook version ([#3345](https://github.com/zeebe-io/zeebe/pull/3345))
* Fix failing QA tests and reduce qa execution time ([#3336](https://github.com/zeebe-io/zeebe/pull/3336))
* chore(broker): use Atomix Raft directly ([#3332](https://github.com/zeebe-io/zeebe/pull/3332))
* chore(deps): bump netty-tcnative-boringssl-static from 2.0.26.Final to 2.0.27.Final ([#3331](https://github.com/zeebe-io/zeebe/pull/3331))
* fix(exporter): allow multiple shards for Elasticsearch indices ([#3330](https://github.com/zeebe-io/zeebe/pull/3330))
* feat(broker): allow process with multiple start events ([#3328](https://github.com/zeebe-io/zeebe/pull/3328))
* chore(deps): bump agrona from 1.0.10 to 1.0.11 ([#3325](https://github.com/zeebe-io/zeebe/pull/3325))
* chore(deps): bump version.sbe from 1.14.0 to 1.14.1 ([#3323](https://github.com/zeebe-io/zeebe/pull/3323))
* chore(deps): bump version.grpc from 1.24.1 to 1.25.0 ([#3322](https://github.com/zeebe-io/zeebe/pull/3322))
* fix(clients/java): omit polling exception if closing ([#3321](https://github.com/zeebe-io/zeebe/pull/3321))
* chore(deps): bump maven-jar-plugin from 3.1.2 to 3.2.0 ([#3313](https://github.com/zeebe-io/zeebe/pull/3313))
* feat(broker): support message start event subprocess ([#3312](https://github.com/zeebe-io/zeebe/pull/3312))
* chore(ci): New pipeline to run chaos tests ([#3304](https://github.com/zeebe-io/zeebe/pull/3304))


<a name="0.22.0-alpha1"></a>
## 0.22.0-alpha1 (2019-11-05)

#### Bug Fixes

* **broker:**
  *  terminate call activity on completing ([74f0664a](https://github.com/zeebe-io/zeebe/commit/74f0664a67a19bd28e8e4aebeb4b01b374243d8f))
  *  don't activate call activity if incident is created ([ac0e2e75](https://github.com/zeebe-io/zeebe/commit/ac0e2e753f8fc000371eaa9c385112e95feb2f46))
  *  fix snapshot-exporter concurrency ([a182118e](https://github.com/zeebe-io/zeebe/commit/a182118eb1513d97ee00d8d8df5830016aa18264))
* **ci:**  fix docker image upload ([7382b6c8](https://github.com/zeebe-io/zeebe/commit/7382b6c8ce3d7c4ec962bf5d266ff891c37bead8))
* **clients/go:**
  *  fix zbctl building failure for Windows ([1eea513d](https://github.com/zeebe-io/zeebe/commit/1eea513d1b9409cec728c3d5f432cd9320a0e785))
  *  env wrapper fall back to actual env ([300e7e59](https://github.com/zeebe-io/zeebe/commit/300e7e59bbaa5c09a1356ddd023ca8fbbc070b0d))
  *  fix concurrency bug in cache access ([c8707393](https://github.com/zeebe-io/zeebe/commit/c8707393b70a34c96818d6d717b957f43493f6a6))
* **gateway:**  fix long polling activation ([74a11a1d](https://github.com/zeebe-io/zeebe/commit/74a11a1dea2d1ec87947043e78083bc051fc00aa))
* **logstreams:**  use concurrent data structure in log storage ([1eb45e31](https://github.com/zeebe-io/zeebe/commit/1eb45e312b37675184b4210f7be43aadac02d6d9))

#### Features

* **broker:**
  *  support interrupting timer event subprocess ([fe39d018](https://github.com/zeebe-io/zeebe/commit/fe39d0184659dcbe5f8eb8847e21dbd1766816d8))
  *  specify variables to include in workflow result ([da9168de](https://github.com/zeebe-io/zeebe/commit/da9168dedc125d8b35c4210947fc1f46bf91226d))
  *  resolve called element by process id expression ([d00f25f8](https://github.com/zeebe-io/zeebe/commit/d00f25f8d5010a352dce5d4468a37d3c1555807a))
  *  support event subprocess with non-interrupt timer ([e0c6b5b9](https://github.com/zeebe-io/zeebe/commit/e0c6b5b90843fc679bc8cd8e3aacf6655a8595d7))
  *  terminate the child instance of the call activity ([1f5f06bd](https://github.com/zeebe-io/zeebe/commit/1f5f06bd282f67977c359d129798cf7900418b0d))
  *  create workflow instance and await completion with results ([1a0a5451](https://github.com/zeebe-io/zeebe/commit/1a0a54518014c6eeb52c879e31bb5cf3ada3c8d3))
  *  copy variables to child workflow instance ([2e0507e2](https://github.com/zeebe-io/zeebe/commit/2e0507e26611295650a07cf0b652a8f74cfeb3c1))
  *  deploy workflow with non-executable elements ([4bfb7df0](https://github.com/zeebe-io/zeebe/commit/4bfb7df03c392a976cdcf43ca9d8794645b7bf1b))
* **clients/go:**
  *  specify list of variables to fetch on workflow instance result ([353a7486](https://github.com/zeebe-io/zeebe/commit/353a7486e03f33f889d4f9d952f6ba2e02dcd79d))
  *  allow to create instance and wait for result ([bb1bf47b](https://github.com/zeebe-io/zeebe/commit/bb1bf47b7a718b1fb292dcea7fe3ed34c8b1e60b))
* **clients/java:**
  *  specify variables to fetch in worklow outcome ([fe415370](https://github.com/zeebe-io/zeebe/commit/fe415370f5782fae507e8476d830b8c5e3f06aac))
  *  create workflow instance and await completion with results ([04797cc9](https://github.com/zeebe-io/zeebe/commit/04797cc936a46c08e44988eff559b79edcdd3205))
  *  change DEFAULT_JOB_WORKER_NAME property value ([a9f0e5bc](https://github.com/zeebe-io/zeebe/commit/a9f0e5bc56592819ee13a815639a4e5e43d70c40))
* **clients/zbctl:**
  *  add flag to wait for workflow instance result ([f3107f1a](https://github.com/zeebe-io/zeebe/commit/f3107f1a8eb124b55e775d23416540f49204a19e))
* **engine:**
  *  support call activities ([1b5a6c6e](https://github.com/zeebe-io/zeebe/commit/1b5a6c6e958dc0c8e7d27a22a47131a514d52ff4))
* **exporter:**  extends exporter metrics to contain valueType info ([8bb9039c](https://github.com/zeebe-io/zeebe/commit/8bb9039ca8208a878b7c2c924b222cbdd56b98ad))
* **logstreams:**  add back pressure on log appender ([cf561bbc](https://github.com/zeebe-io/zeebe/commit/cf561bbcd36f4593f35a717ae7a366c804de2ea8))


<a name="0.21.0"></a>
## 0.21.0 (2019-10-01)


#### Features

* **broker:**  add job type to metrics ([4f0067d2](https://github.com/zeebe-io/zeebe/commit/4f0067d2b64c8cedfe2a33059559909806314848))
* **clients/go:**  add env vars for auth configuration ([09021f21](https://github.com/zeebe-io/zeebe/commit/09021f21fb529e00c96d9f79cc73526ea7beb88a), breaks [#](https://github.com/zeebe-io/zeebe/issues/))
* **clients/java:**  add env vars for auth configuration ([bfaa15c3](https://github.com/zeebe-io/zeebe/commit/bfaa15c3c60d8ae0975ac4076f40e5fc3baf1a24), breaks [#](https://github.com/zeebe-io/zeebe/issues/))


#### Bug Fixes

* **clients/java:**  ignore unknown JSON properties with object mapper ([a5b0af16](https://github.com/zeebe-io/zeebe/commit/a5b0af16a5fa020ad1ff092ec2bdc09824857246))
* **exporters/elasticsearch:**  log error on flush exception instead of failing ([1b37a3e4](https://github.com/zeebe-io/zeebe/commit/1b37a3e4e29e2ca57cd56475b0ef63b9783605f9))


<a name="0.21.0-alpha3"></a>
## 0.21.0-alpha3 (2019-09-11)


#### Features

* **clients/java:**  cache client credentials ([168546bc](https://github.com/zeebe-io/zeebe/commit/168546bc4dbea569249700f3aa7529e8d2f06305))

#### Bug Fixes

* **gateway:**  fix long polling activation ([74a11a1d](https://github.com/zeebe-io/zeebe/commit/74a11a1dea2d1ec87947043e78083bc051fc00aa))



<a name="0.21.0-alpha2"></a>
## 0.21.0-alpha2 (2019-09-03)

#### Features

* **broker:**
  *  apply variable mappings on multi-instance activity ([68b4c915](https://github.com/zeebe-io/zeebe/commit/68b4c915f2cc115c9e1198f7df11461f252bd49a))
  *  deploy larger workflows ([8885fccb](https://github.com/zeebe-io/zeebe/commit/8885fccb8c45e3ae2e9034994bdc4458b09a48bb))
  *  set multi-instance loop counter variable ([49000f38](https://github.com/zeebe-io/zeebe/commit/49000f38594f5c48c67675ca6e558f3db1ada86a))
  *  collect the output of a multi-instance activity ([c7f9ea25](https://github.com/zeebe-io/zeebe/commit/c7f9ea25b1697ef0499871df7e1fd011dd496c6c))
  *  trigger boundary events on multi-instance activities ([b253a470](https://github.com/zeebe-io/zeebe/commit/b253a470b3f368c75ec7529980d715acedbb3524))
  *  configure long polling timeout per request ([1d54b51f](https://github.com/zeebe-io/zeebe/commit/1d54b51fb095542c388e1ba94e7c844710bafae6))
* **clients/go:**
  *  add refresh token and retry logic ([ef2af905](https://github.com/zeebe-io/zeebe/commit/ef2af9057c350c057e08a49beeb29cb82f1c6fd2))
  *  add OAuth credentials provider to Go client ([63b378b4](https://github.com/zeebe-io/zeebe/commit/63b378b4de80e03d33ce98a0696a97a33996fcdc))
  *  add credentials support in Go client ([d9e30b8f](https://github.com/zeebe-io/zeebe/commit/d9e30b8f8f1ca093477608ff9d551a05e21283b4))
  *  configure long polling timeout per request ([b51159ce](https://github.com/zeebe-io/zeebe/commit/b51159ce9629f59e95949bc59bb7a3da6eab4ecf))
* **clients/java:**
  *  refresh credentials and retry requests ([d90a30b1](https://github.com/zeebe-io/zeebe/commit/d90a30b114b8b15670746ea28fc5f52e8dedecd2))
  *  add OAuth credentials provider ([2cae751e](https://github.com/zeebe-io/zeebe/commit/2cae751e3765ed2ae9e4b1e6f64f200621a2b56d))
* **clients/zbctl:**
  *  support OAuth credentials in zbctl ([63167d4a](https://github.com/zeebe-io/zeebe/commit/63167d4a8fca1e07a16080d01691d40de82a20c1))
  *  add credentials support to zbctl ([ee4a9b4a](https://github.com/zeebe-io/zeebe/commit/ee4a9b4a8749cb6842812a91033748fdd31e144d))
  *  configure long polling timeout per request ([28a92262](https://github.com/zeebe-io/zeebe/commit/28a922627b4e41fd0665e286b9aa3a886ddf4737))

#### Bug Fixes

* **broker:**
  *  avoid NPE on model validation of messages ([bd7d54a7](https://github.com/zeebe-io/zeebe/commit/bd7d54a720cf18c4ece19012ceedad8b3a42414d))
  *  cancel workflow instance properly ([7dc8ea46](https://github.com/zeebe-io/zeebe/commit/7dc8ea46dd4db5a3278ade4818b42b3a5db5d3b2))


<a name="0.21.0-alpha1"></a>
## 0.21.0-alpha1 (2019-08-06)


#### Features

* **broker:**
  *  support sequential multi-instance activity ([01c5ad68](https://github.com/zeebe-io/zeebe/commit/01c5ad6829633e0feebaeb3e7fad88deb7c2b185))
  *  records are not copied for exporters ([493c5719](https://github.com/zeebe-io/zeebe/commit/493c57197e7e638454130ad4ff239e7d43c989e1))
  *  implement long polling for activate jobs request ([97115919](https://github.com/zeebe-io/zeebe/commit/97115919199c7a85aceabe9c36fa2add6fd4eb95))
  *  distinguish multi-instance body records ([eb9e2c88](https://github.com/zeebe-io/zeebe/commit/eb9e2c883871c0b7d96d35e06903457e101d9d8b))
  *  parallel multi-instance sub-process and receive task ([59b2609e](https://github.com/zeebe-io/zeebe/commit/59b2609e218b5770c33d630bcbc596ce44e87914))
  *  support parallel multi-instance service task ([07c384ca](https://github.com/zeebe-io/zeebe/commit/07c384ca4e722cbb9a8823612d008cb11d272f9d))
  *  add TLS support to gateway ([fe3359eb](https://github.com/zeebe-io/zeebe/commit/fe3359ebf2472b1ba36069cf1c7dff1d6b3c17c3))
* **clients/go:**  add TLS support in Go client ([f7d926d5](https://github.com/zeebe-io/zeebe/commit/f7d926d58f48399357f4a0f4db469533120b50a7))
* **clients/java:**
  *  support credentials in Java client ([8a803244](https://github.com/zeebe-io/zeebe/commit/8a80324423086f37a373ea8904603323767abb76))
  *  added TLS support in Java client ([3787442c](https://github.com/zeebe-io/zeebe/commit/3787442c9d8212b68e4c3cf930170494f4075cf8))
* **clients/zbctl:**  add TLS support to zbctl ([f7d8c460](https://github.com/zeebe-io/zeebe/commit/f7d8c4608894118fcbe538e7c2822fc610dfbbd7))

#### Bug Fixes

* **broker:**
  *  take outgoing sequence flow after multi-instance ([a4ce2f19](https://github.com/zeebe-io/zeebe/commit/a4ce2f191092b7c781af0b410d6410f3180578c6))
  *  avoid retrying the wrong deployment ([6fc84612](https://github.com/zeebe-io/zeebe/commit/6fc846129945b988d219cbd144050ebc52b4944f))



<a name="0.20.0"></a>
## 0.20.0 (2019-07-16)


#### Features

* **exporters/elasticsearch:**  export error events by default ([e9955a3f](https://github.com/zeebe-io/zeebe/commit/e9955a3f8d26371b3b6bdccf15428ec992c77466))

#### Bug Fixes

* **broker:**
  *  fix missing deployment distribution during concurrent deployments ([3fe670a7](https://github.com/zeebe-io/zeebe/commit/3fe670a72337a7bc7c74b7f9a213f9bd31698d51))
  *  fix JS script of DEBUG HTTP exporter ([615b2f26](https://github.com/zeebe-io/zeebe/commit/615b2f269e07d915fd9facc35b0578fad4479b21))
  *  fix cleaning up job state on cancelling ([9413afbc](https://github.com/zeebe-io/zeebe/commit/9413afbc25aeb9ad907f52c12902f8f3fc562576))
* **clients/java:**  assertion for variables allow null values ([739427cd](https://github.com/zeebe-io/zeebe/commit/739427cd8ecbde7c9e1d586c9d1803d8359dff0b))


<a name="0.19.0"></a>
## 0.19.0 (2019-07-02)

#### Breaking Changes

* **broker:**
  *  migrate RecordValue interfaces to protocol ([e19529f1](https://github.com/zeebe-io/zeebe/commit/e19529f1efba8b7206502bf8e3e55d372e6f62ee))
  *  change package of asserts and generated types ([9abc82236](https://github.com/zeebe-io/zeebe/commit/9abc82236bc0cd9b2d406ada2e2a59b6e2d63485))
  *  change type of Record#getTimestamp() to Long ([04414316](https://github.com/zeebe-io/zeebe/commit/04414316f92c82a5a452c7a52d50f7b9893b29d4))
  *  rename keys in workflow instance creation mapping ([d32286b1](https://github.com/zeebe-io/zeebe/commit/d32286b15bc0ca8e557532bf02644a78eea67cfe))
  *  disable variable indexing in elasticsearch exporter mappings ([44a38909](https://github.com/zeebe-io/zeebe/commit/44a38909bb729cdef144472c9d8fa4a04868bd0d))
  *  disable indexing of deployment resource in elasticsearch ([8465e6a0](https://github.com/zeebe-io/zeebe/commit/8465e6a0fcc1ed5286b6da8e66f7935fcc92125d))
  *  remove metrics file writer ([2aae727d](https://github.com/zeebe-io/zeebe/commit/2aae727d229a2fd4718496a3ec328585712eb164))
  *  rename document to variables in VariableDocumentRecord ([41975975](https://github.com/zeebe-io/zeebe/commit/41975975c207385b57622da5d71c2c5df98acce6))
  *  flatten RecordMetadata into Record ([6593979f](https://github.com/zeebe-io/zeebe/commit/6593979f19174861fe49c58204bc556cef1503fd))
  *  squash job headers into record value ([46c8061d](https://github.com/zeebe-io/zeebe/commit/46c8061d82120cecdbd6add93268e9b6b6a5a65c))
  *  change custom headers to Map<String,String> ([2d05e3bd](https://github.com/zeebe-io/zeebe/commit/2d05e3bdf56b15efa3f3b6ac5a1056cf0deb9126))
  *  IncidentRecord return ErrorType instead of String ([79e2c080](https://github.com/zeebe-io/zeebe/commit/79e2c080e4b7d4d1368db896f63dd0b473baf598))
  *  remove producer id from record ([ff6b1dd5](https://github.com/zeebe-io/zeebe/commit/ff6b1dd5b6516110c105e7dd949d154a519f3179))
  *  rework WorkflowInstanceCreationRecordValue ([7ee99e7e](https://github.com/zeebe-io/zeebe/commit/7ee99e7e91939ee58d94dcdf6bd36e1bbbb1a06a))
* **clients/go:**  flatten job headers ([1a1555de](https://github.com/zeebe-io/zeebe/commit/1a1555de62ce38cf0ddcacd7577ed8160d8a1ac1))
* **clients/java:**  reorganize packages ([cdccc34c](https://github.com/zeebe-io/zeebe/commit/cdccc34c2fd8daa41b398b5bc46a20aea337f096))

#### Features

* **broker:**
  *  filter duplicated deployments ([c34e5995](https://github.com/zeebe-io/zeebe/commit/c34e59958afc858b1f164b086a6245820215bec5))
  *  expose elasticsearch exporter metrics ([62448c75](https://github.com/zeebe-io/zeebe/commit/62448c757edd197c3a6e88722b2f3979016e63cc))
  *  add exporter back off retry strategy ([9a92c04b](https://github.com/zeebe-io/zeebe/commit/9a92c04bb0d631076c2b7f3dbc08804952e1dbf7))
* **clients/java:**
  *  allow job handlers to throw exceptions ([77192a92](https://github.com/zeebe-io/zeebe/commit/77192a92b614bd165c0ce9af70473f08e5d1625e))
  *   allow to set request timeout ([2d7ac6b9](https://github.com/zeebe-io/zeebe/commit/2d7ac6b9476e2731fb012b37f8ac61f2134bb073))
* **gateway:**  add grpc metrics ([aa7f47a6](https://github.com/zeebe-io/zeebe/commit/aa7f47a6f3921503d5647414fcbd8633da880d7f))

#### Bug Fixes

* **broker:**
  *  fixed missing distributed CREATEs during restart ([a24c04f4](https://github.com/zeebe-io/zeebe/commit/a24c04f4f114e731945241d38689cd4e749d65ed))
  *  reject deployments with duplicate process ids ([46c929e4](https://github.com/zeebe-io/zeebe/commit/46c929e40406c40ba8d81d022da8f4bd43174bd3))
  *  copy deployment resources ([b79697a1](https://github.com/zeebe-io/zeebe/commit/b79697a1046d9e4f59503255d2cafa262f41715c))
  *   fix transformation to get deployed workflows ([743fe20a](https://github.com/zeebe-io/zeebe/commit/743fe20a492e5cf3e682b2d93b978bb69de1eed6))
* **docker:**  remove deprecated JVM option ([950795f8](https://github.com/zeebe-io/zeebe/commit/950795f869367d1eb13036b1492a84486284d233))

<a name="0.19.0-alpha3"></a>
## 0.19.0-alpha3 (2019-06-28)

#### Breaking Changes

* **broker:**  change type of Record#getTimestamp() to Long ([04414316](https://github.com/zeebe-io/zeebe/commit/04414316f92c82a5a452c7a52d50f7b9893b29d4))

#### Features

* **broker:**
  *  expose elasticsearch exporter metrics ([62448c75](https://github.com/zeebe-io/zeebe/commit/62448c757edd197c3a6e88722b2f3979016e63cc))
  *  add exporter back off retry strategy ([9a92c04b](https://github.com/zeebe-io/zeebe/commit/9a92c04bb0d631076c2b7f3dbc08804952e1dbf7))
* **clients/java:**  allow job handlers to throw exceptions ([77192a92](https://github.com/zeebe-io/zeebe/commit/77192a92b614bd165c0ce9af70473f08e5d1625e))
* **gateway:**  add grpc metrics ([aa7f47a6](https://github.com/zeebe-io/zeebe/commit/aa7f47a6f3921503d5647414fcbd8633da880d7f))

#### Bug Fixes

* **broker:**
  *  reject deployments with duplicate process ids ([46c929e4](https://github.com/zeebe-io/zeebe/commit/46c929e40406c40ba8d81d022da8f4bd43174bd3))
  *  copy deployment resources ([b79697a1](https://github.com/zeebe-io/zeebe/commit/b79697a1046d9e4f59503255d2cafa262f41715c))


<a name="0.19.0-alpha2"></a>
## 0.19.0-alpha2 (2019-06-25)


#### Breaking Changes

* **broker:**
  *  rename keys in workflow instance creation mapping ([d32286b1](https://github.com/zeebe-io/zeebe/commit/d32286b15bc0ca8e557532bf02644a78eea67cfe))
  *  disable variable indexing in elasticsearch exporter mappings ([44a38909](https://github.com/zeebe-io/zeebe/commit/44a38909bb729cdef144472c9d8fa4a04868bd0d))
  *  disable indexing of deployment resource in elasticsearch ([8465e6a0](https://github.com/zeebe-io/zeebe/commit/8465e6a0fcc1ed5286b6da8e66f7935fcc92125d))
  *  remove metrics file writer ([2aae727d](https://github.com/zeebe-io/zeebe/commit/2aae727d229a2fd4718496a3ec328585712eb164))
  *  rename document to variables in VariableDocumentRecord ([41975975](https://github.com/zeebe-io/zeebe/commit/41975975c207385b57622da5d71c2c5df98acce6))
  *  flatten RecordMetadata into Record ([6593979f](https://github.com/zeebe-io/zeebe/commit/6593979f19174861fe49c58204bc556cef1503fd))
  *  squash job headers into record value ([46c8061d](https://github.com/zeebe-io/zeebe/commit/46c8061d82120cecdbd6add93268e9b6b6a5a65c))
  *  change custom headers to Map<String,String> ([2d05e3bd](https://github.com/zeebe-io/zeebe/commit/2d05e3bdf56b15efa3f3b6ac5a1056cf0deb9126))
  *  IncidentRecord return ErrorType instead of String ([79e2c080](https://github.com/zeebe-io/zeebe/commit/79e2c080e4b7d4d1368db896f63dd0b473baf598))
  *  remove producer id from record ([ff6b1dd5](https://github.com/zeebe-io/zeebe/commit/ff6b1dd5b6516110c105e7dd949d154a519f3179))
  *  change return type of Record#getVariables() to map ([d0e9bf200](https://github.com/zeebe-io/zeebe/commit/d0e9bf2000728bc9bb420b525072a29f3a5530f9))
  *  rework WorkflowInstanceCreationRecordValue ([7ee99e7e](https://github.com/zeebe-io/zeebe/commit/7ee99e7e91939ee58d94dcdf6bd36e1bbbb1a06a))
* **clients/go:**  flatten job headers ([1a1555de](https://github.com/zeebe-io/zeebe/commit/1a1555de62ce38cf0ddcacd7577ed8160d8a1ac1))
* **clients/java:**  reorganize packages ([cdccc34c](https://github.com/zeebe-io/zeebe/commit/cdccc34c2fd8daa41b398b5bc46a20aea337f096))

#### Features

* **broker:**  filter duplicated deployments ([c34e5995](https://github.com/zeebe-io/zeebe/commit/c34e59958afc858b1f164b086a6245820215bec5))


<a name="0.19.0-alpha1"></a>
## 0.19.0-alpha1 (2019-06-18)

#### Breaking Changes

* **broker:**
  *  migrate RecordValue interfaces to protocol ([e19529f1](https://github.com/zeebe-io/zeebe/commit/e19529f1efba8b7206502bf8e3e55d372e6f62ee))
  *  change package of asserts and generated types ([9abc82236](https://github.com/zeebe-io/zeebe/commit/9abc82236bc0cd9b2d406ada2e2a59b6e2d63485))

#### Bug Fixes

* **docker:**  remove deprecated JVM option ([950795f8](https://github.com/zeebe-io/zeebe/commit/950795f869367d1eb13036b1492a84486284d233))
* **broker:**  fix transformation to get deployed workflows ([743fe20a](https://github.com/zeebe-io/zeebe/commit/743fe20a492e5cf3e682b2d93b978bb69de1eed6))

#### Features

* **clients/java:**  allow to set request timeout ([2d7ac6b9](https://github.com/zeebe-io/zeebe/commit/2d7ac6b9476e2731fb012b37f8ac61f2134bb073))



<a name="0.18.0"></a>
## 0.18.0 (2019-06-06)

#### Breaking Changes

* **broker:**
  *  rename port configuration ([02e3c472](https://github.com/zeebe-io/zeebe/commit/02e3c4720800c8067055efdd4b76d06786dcb007))
  *  rename defaultLogSegmentSize to logSegmentSize in configuration ([915fd5e5](https://github.com/zeebe-io/zeebe/commit/915fd5e571b41bcf76dad801c448acf5d24ce544))
* **exporter-api:**  move Exporter interface to upper api package ([faac031f](https://github.com/zeebe-io/zeebe/commit/faac031f3b84557793778b504dd02699477bdf0a))
* **protocol:**  move protocol class to upper level package ([8f580c51](https://github.com/zeebe-io/zeebe/commit/8f580c51c3f70efb16f39c08fdff6ee8792e3bbf))
* **gateway-protocol:**  remove control messages (list and get workflows) ([8a6035676](https://github.com/zeebe-io/zeebe/commit/8a6035676fb0eaf2bc79d1e3eacad8e683f787bb))


#### Bug Fixes

* **broker:**
  *  rename port configuration ([02e3c472](https://github.com/zeebe-io/zeebe/commit/02e3c4720800c8067055efdd4b76d06786dcb007))
  *  rename defaultLogSegmentSize to logSegmentSize in configuration ([915fd5e5](https://github.com/zeebe-io/zeebe/commit/915fd5e571b41bcf76dad801c448acf5d24ce544))
  *  fix lost messages on rejected correlation ([cdcddd86](https://github.com/zeebe-io/zeebe/commit/cdcddd863b1d3f591839319840f9f5ca8c3bc076))
  *  fix intermediate catch event XML order dependency ([5c25ecd1](https://github.com/zeebe-io/zeebe/commit/5c25ecd17aa55f8cc223868df59530b412f9cfca))
  *  fix XOR gateway being dependent on element position in XML ([bdd88dc1](https://github.com/zeebe-io/zeebe/commit/bdd88dc1465d522eebb3032976eb10a85cfa9c24))
  *  do not skip partition on job activation ([80307830](https://github.com/zeebe-io/zeebe/commit/80307830bd9e750e5a7ec82829032a9f1cbafa05))
  *  fix invalid state when cancelling with job ([f990274a](https://github.com/zeebe-io/zeebe/commit/f990274af2647a6b51f52d448a3b5829824bb898))
  *  fix reading empty string token ([638e0631](https://github.com/zeebe-io/zeebe/commit/638e0631514160bdc74b280f61ac3c2cf44aca75))
* **exporter-api:**  move Exporter interface to upper api package ([faac031f](https://github.com/zeebe-io/zeebe/commit/faac031f3b84557793778b504dd02699477bdf0a))
* **gateway:**  fix topology response ([ea92e981](https://github.com/zeebe-io/zeebe/commit/ea92e98102e1acb1bbefce822aaa796918504e54))
* **protocol:**  move protocol class to upper level package ([8f580c51](https://github.com/zeebe-io/zeebe/commit/8f580c51c3f70efb16f39c08fdff6ee8792e3bbf))

#### Features

* **broker:**  add workflow key to incident record ([73477e87](https://github.com/zeebe-io/zeebe/commit/73477e875a8575c0e9f278df92858595b4ae821f))
* **clients/java:**  send stack trace of unhandled worker exception to Operate ([7ceea4ce](https://github.com/zeebe-io/zeebe/commit/7ceea4ce104d1421eff1965f8b36fa499c9b2305))
* **exporter-api:**  allow exporters to throw checked exceptions in configure method ([df52c92b](https://github.com/zeebe-io/zeebe/commit/df52c92b3edeb655462e2f5bcb1253526a8d8181))


<a name="0.17.0"></a>
## 0.17.0 (2019-04-02)


#### Breaking Changes

* **broker:**
  * renamed payload to variables ([e2fed8bc](https://github.com/zeebe-io/zeebe/commit/e2fed8bc7d15092deb701cba5f0b158d250c2485))
  * input/output mappings and correlation key expressions access variables by name ([665393f0](https://github.com/zeebe-io/zeebe/commit/665393f0206c54cf0373cc7ac54edeec31b3f460))
* **clients:**  rename bufferSize to maxJobsActive ([2373c264](https://github.com/zeebe-io/zeebe/commit/2373c2649da13755e964f83a530d9adb3e6798ed))
* **json-el:**  conditions access variables by name instead of JSON path ([645297e8](https://github.com/zeebe-io/zeebe/commit/645297e84eb678707ea56a896421c1c1b3587314))
* **maven:**  prefix all maven artifacts with zeebe ([b2bac603](https://github.com/zeebe-io/zeebe/commit/b2bac603d565d581827dbcee1470d382a4e6e3b5))

#### Features

* **bpmn-model:**  reject end events with outgoing sequence flows ([50582295](https://github.com/zeebe-io/zeebe/commit/50582295a9b7588c27798173a7135398b7239357))
* **broker:**
  * add workflow key to variable record ([624d32a2](https://github.com/zeebe-io/zeebe/commit/624d32a2fc3f3c9941fbe2603cb32e1db1a6ac9d))
  * input/output mappings and correlation key expressions access variables by name ([665393f0](https://github.com/zeebe-io/zeebe/commit/665393f0206c54cf0373cc7ac54edeec31b3f460))
* **exporter:**  export error record ([b35728bf](https://github.com/zeebe-io/zeebe/commit/b35728bfe3542a6c5beccea5dcfd290c02853d2e))
* **json-el:**  conditions access variables by name instead of JSON path ([645297e8](https://github.com/zeebe-io/zeebe/commit/645297e84eb678707ea56a896421c1c1b3587314))
* **protocol:**  introduce new ErrorRecord ([21ca50a8](https://github.com/zeebe-io/zeebe/commit/21ca50a8ac065b7f33daa6908d83f7924668679b))

#### Bug Fixes

* **broker:**
  *  prevent unnecessary message subscription closing ([37a03bf0](https://github.com/zeebe-io/zeebe/commit/37a03bf06458f0e710b592ca74c256414283a4bd))
  *  prevent NPE in delayed message subscription closing ([d733cee5](https://github.com/zeebe-io/zeebe/commit/d733cee5c882ae1e9bc3e7d93e32d9c05bb948c4))
  *  renamed payload to variables ([e2fed8bc](https://github.com/zeebe-io/zeebe/commit/e2fed8bc7d15092deb701cba5f0b158d250c2485))
  *  reset reused event scope instance ([f9c3e7f3](https://github.com/zeebe-io/zeebe/commit/f9c3e7f363d8be16e9cbd7001f48d8ed23821f56))
  *  stop iterating jobs if job batch reached max capacity ([91f276d9](https://github.com/zeebe-io/zeebe/commit/91f276d954df4e68c665c584e0c737fa716b3e63))
  *  increase gateway transport buffer to default 64 megabyte ([fbf07e29](https://github.com/zeebe-io/zeebe/commit/fbf07e29562f47d77e18e32d34eda829b445bd56))
* **clients:**  rename bufferSize to maxJobsActive ([2373c264](https://github.com/zeebe-io/zeebe/commit/2373c2649da13755e964f83a530d9adb3e6798ed))
* **clients/java:**  clarify outdated update job retries java doc ([5881187f](https://github.com/zeebe-io/zeebe/commit/5881187f619e0addd9aa81c7f7f30d3fc3bb94f0))
* **exporters/elasticsearch-exporter:**  migrates ES to pkg io.zeebe.exporter ([7106f167](https://github.com/zeebe-io/zeebe/commit/7106f16755c52d32ffc8709d5a83e3c6ba4b067b))
* **logstreams:**
  *  removed StreamProcessorControllerTest race condition ([3ad0e3ac](https://github.com/zeebe-io/zeebe/commit/3ad0e3ac05304f5aa6f114e1568e9c2a013bf647))
  *  removed race condition from LogBlockIndexWriterTest ([134c5b1b](https://github.com/zeebe-io/zeebe/commit/134c5b1b424ca123e6e079d385544f64c6387327))
* **maven:**  prefix all maven artifacts with zeebe ([b2bac603](https://github.com/zeebe-io/zeebe/commit/b2bac603d565d581827dbcee1470d382a4e6e3b5))



<a name="0.16.4"></a>
## 0.16.4 (2019-03-22)


#### Bug Fixes

* **broker:**  use default RocksDB column family options ([4393958b](https://github.com/zeebe-io/zeebe/commit/4393958b76f115a565d38ec8b92af66d75215a00))


<a name="0.16.3"></a>
## 0.16.3 (2019-03-15)


#### Bug Fixes

* **broker:**
  *  stop iterating jobs if job batch reached max capacity ([cc90c04a](https://github.com/zeebe-io/zeebe/commit/cc90c04a3e0e5d625c1cae36d4ae3c9bd446a579))
  *  increase gateway transport buffer to default 64 megabyte ([449ea10e](https://github.com/zeebe-io/zeebe/commit/449ea10e61712d768cccb166ecc8f5ed79e2f71d))



<a name="0.16.2"></a>
## 0.16.2 (2019-03-11)


#### Bug Fixes

* **broker:**
  * update workflow instance created metric correctly ([a627ea78](https://github.com/zeebe-io/zeebe/commit/a627ea78d09dec22cdc0474165e8a7e37055a2e1))
  * time out trigger respects dispatcher backpressure ([41037895](https://github.com/zeebe-io/zeebe/commit/4103789534bcc75a97a795a102580ba8ec2665ed))

#### Features

* **broker:**  add HTTP metrics endpoint ([131a57fc](https://github.com/zeebe-io/zeebe/commit/131a57fc27cff00417a677d6e4ddfa8cffd9940a))



<a name="0.16.1"></a>
## 0.16.1 (2019-03-07)


#### Features

* **broker:**  condition expression is part of incident message ([447091aa](https://github.com/zeebe-io/zeebe/commit/447091aa3df1c91a17c6f4fd3ef9800f894a7078))
* **clients/go:**  replace update payload with set variables ([49ae37ab](https://github.com/zeebe-io/zeebe/commit/49ae37abc1f54eb6f68e9a5b8621b818802b2dc1))
* **exporters/elasticsearch-exporter:**  adds basic HTTP auth to exporter ([791ea802](https://github.com/zeebe-io/zeebe/commit/791ea802d682fcc15678340d29163043028038fc))

#### Bug Fixes

* **broker:**
  *  set correct license information in pom file ([a6bd1ec8](https://github.com/zeebe-io/zeebe/commit/a6bd1ec8b81c7dae24c805b44f87ceb135dc6edd))
  *  send close message subscription command to correct partition ([b5600170](https://github.com/zeebe-io/zeebe/commit/b56001709b4693acd037f92e4724119a991cf2ce))
  *  set correct BPMN element type for sequence flows ([74f93a3e](https://github.com/zeebe-io/zeebe/commit/74f93a3e9654c89309a79c6ccf47e6a23081859d))
  *  set repetitions and reset timer record ([418eedc9](https://github.com/zeebe-io/zeebe/commit/418eedc9be1a8f3a827d4f9cf81880ca0ef145d3))
  *  only distribute deployments from first partition ([a2a069c9](https://github.com/zeebe-io/zeebe/commit/a2a069c9e70430892c2418710bf1c58ee75b9b76))
  *  fix timer start events key ([833f3246](https://github.com/zeebe-io/zeebe/commit/833f3246f668537044587fc3cb255c9789d9bfae))
  *  fix overflows ([5833ee56](https://github.com/zeebe-io/zeebe/commit/5833ee563aa30300bd34daf6b38bad225bf8968d))
  *  stop iterating after prefix was exceeded ([c5c38ba9](https://github.com/zeebe-io/zeebe/commit/c5c38ba9a3cb840ea7c7105376c2d7b9a263e23d))



<a name="0.15.1"></a>
## 0.15.1 (2019-02-26)


#### Bug Fixes

* **broker:**  stop iterating after prefix was exceeded ([0e873c6a](https://github.com/zeebe-io/zeebe/commit/0e873c6a90708be762ca40119f839d3efef2cb87))



<a name="0.15.0"></a>
## 0.15.0 (2019-02-12)


#### Bug Fixes

* **broker:**
  *  reject deployment which contains at least one invalid resource ([fd478adc](https://github.com/zeebe-io/zeebe/commit/fd478adc2691b427c54389461c6f4bdd685d7267))
  *  ensure YAML transformation does not break the msgpack serialization ([575178cf](https://github.com/zeebe-io/zeebe/commit/575178cf87a05fff1db6ecc8eb31d89a94a547b5))
  *  limit jobs in JobBatchRecord to 65Kb ([6324a8e5](https://github.com/zeebe-io/zeebe/commit/6324a8e5b905cfc10b38e8688f94cb381b132ff4))
  *  reject create workflowinstance command when there is no none start event ([7651fcc7](https://github.com/zeebe-io/zeebe/commit/7651fcc73cbe50639e60fb40caf3c9c6fe06b8fb))
  *  expand log block index if capacity is reached ([1b6adfeb](https://github.com/zeebe-io/zeebe/commit/1b6adfeb5060dd4ae6b1ba27d6b706898e4b9b15))
  *  fix state interference with processor ([5b948b09](https://github.com/zeebe-io/zeebe/commit/5b948b09dcbe19b4fdae5e0d98bd5f727d7855fb))
  *  ignore empty or invalid task headers ([7cb055c8](https://github.com/zeebe-io/zeebe/commit/7cb055c8c858477f84b05516eca74a0b0e1aff2f))
  *  reject empty correlation key ([879ae05a](https://github.com/zeebe-io/zeebe/commit/879ae05a35d7b582ff6158560917d32f566ec616))
  *  event-based gateways can't be triggered twice ([e5c38366](https://github.com/zeebe-io/zeebe/commit/e5c3836613203f43c98e5c3415278094a4c4399e))
  *  prevent canceling of element instances ([a9b16ae0](https://github.com/zeebe-io/zeebe/commit/a9b16ae05266fed49569ffc676ac3576b2a126cc))
  *  don't open subscription if incident is raised ([6e2f3671](https://github.com/zeebe-io/zeebe/commit/6e2f3671862b85dfa2dbf833f71674898b9ee483))
  *  save the last exported record position before closing the state * ensure the RocksDB directory is deleted ([cd912d8f](https://github.com/zeebe-io/zeebe/commit/cd912d8fb3e2ebb378bc34570f4484cfdbd159f2))
  *  close gateway before service containers ([cd74ac24](https://github.com/zeebe-io/zeebe/commit/cd74ac24911b94931d31c78ed38cae8b0171436a))
  *  ignore unreferenced messages in transformer ([6c9f1035](https://github.com/zeebe-io/zeebe/commit/6c9f1035b3e33eee7b0cedaa4554ea206d7d3753))
  *  Convert numeric correlation key to string ([953ec7b7](https://github.com/zeebe-io/zeebe/commit/953ec7b7632f77205bd5ae7334f38b427a932009))
  * add explicit endianness in logstream ([d8dbd667](https://github.com/zeebe-io/zeebe/commit/d8dbd6670dea805ba1154f8a91cbeb6987f601ad))
  * avoid overflow on String16 type ([bf2fb4cd](https://github.com/zeebe-io/zeebe/commit/bf2fb4cdd2dcfa10b91b0dcde05160def289a5f6))

#### Features

* **broker:**
  *  add workflowInstanceKey to variable records ([35b2f1e4](https://github.com/zeebe-io/zeebe/commit/35b2f1e45351d29109a2fef0810116ca6661f72f))
  *  unify lifecycle of flow elements ([7c2589ab](https://github.com/zeebe-io/zeebe/commit/7c2589abf5ca310e8fc3909cc2b8c042e45db55a))
  *  improve error reporting in gRPC API ([c02e6d80](https://github.com/zeebe-io/zeebe/commit/c02e6d801a1cb2748767b36a718b31e8cca5fbf1))
  *  added bpmn element type to WorkflowInstanceRecord ([09e7e0c5](https://github.com/zeebe-io/zeebe/commit/09e7e0c5b4159185a475b3b341d7c4bfa45b360b))
  *  export variable records to elasticsearch ([f96aa8fc](https://github.com/zeebe-io/zeebe/commit/f96aa8fce13ba9c94f083195d92cc791ecebc6bc))
  *  consistent and meaningful error message format ([ff34a27a](https://github.com/zeebe-io/zeebe/commit/ff34a27ae719ae42ade4248f1a7e17cae749022e))
  *  add list of variables to be fetched on activation to protocol ([7a7d63ca](https://github.com/zeebe-io/zeebe/commit/7a7d63ca8835602e4203d437259eef342b8b7640))
  *  added support for timeDate timer definitions ([ae1823a0](https://github.com/zeebe-io/zeebe/commit/ae1823a0d4dd2d2a0aa10f5a7bd4a418644e165c))
  *  support timer start event ([f28c318b](https://github.com/zeebe-io/zeebe/commit/f28c318b25c3ffa6654016dae45e8fe12a4a9149))
  *  support non-interrupting message boundary events ([4fa149fb](https://github.com/zeebe-io/zeebe/commit/4fa149fbaf29bef34e30001b9fa28573bd9e7d39))
  *  support message start events ([2364e08c](https://github.com/zeebe-io/zeebe/commit/2364e08cdcd8f59a87b37c51cb9db7d9e4d84a42)) ([157e66e2](https://github.com/zeebe-io/zeebe/commit/157e66e21ec135216e3f69724395c14fe6849c2a))
  *  write variable events ([40b32063](https://github.com/zeebe-io/zeebe/commit/40b3206329e1e19c18f98d557eb3403dfebe6d3b))
  *  propagate variables on presence of out mappings ([64f45fbe](https://github.com/zeebe-io/zeebe/commit/64f45fbe29ba51417e75c848c730569ba47d0c1e))
  *  allow updating job retries in all job states ([6e056f7f](https://github.com/zeebe-io/zeebe/commit/6e056f7f21c099dc26dfa61a554eb3b13f0f724f))
  *  support non-interrupting timer boundary events ([84313356](https://github.com/zeebe-io/zeebe/commit/8431335624d02941e90b568c13e74b847f65f3a7))
  * allow non-strict condtions ([c8f4480d](https://github.com/zeebe-io/zeebe/commit/c8f4480d707048ad9ae4dfcda685483485cda2e0))
  *  provide integration test utitilities for exporter authors ([5cbbcfc9](https://github.com/zeebe-io/zeebe/commit/5cbbcfc948b7d16e6a9f7f4641774675f60ac219))
  *  adds a slew of Exporter test utilities ([899221ea](https://github.com/zeebe-io/zeebe/commit/899221ead4b03a2c017fcb410ba22bc4367a6985))
* **clients/go:**
  * add optional list of variables to activate jobs/job worker ([911aeea5](https://github.com/zeebe-io/zeebe/commit/911aeea5f08bcd02239236d18b140a43c1031f4a))
  * Add omitempty-ignoring object marshaller method to go api ([4823b42b](https://github.com/zeebe-io/zeebe/commit/4823b42b865bdc4e14be96c6d55cdd4e6dc4502b))
* **clients/java:**
    *  add optional list of variables to activate jobs/job worker ([6eabff25](https://github.com/zeebe-io/zeebe/commit/6eabff250e1226ac197a0c5f2c327f80e79bc99a))
    *  propagate job worker exception message to broker ([23a70ea8](https://github.com/zeebe-io/zeebe/commit/23a70ea83a69fd9005dd5ebd38403b18f18939aa))
* **clients/zbctl:**  set error message in fail command to stderr content ([8f8b3889](https://github.com/zeebe-io/zeebe/commit/8f8b3889079559a83a5ec3cdc83fa40f80321f3b))


<a name="0.14.0"></a>
## 0.14.0 (2018-12-04)


#### Bug Fixes

* **broker-core:**
  *  update job state on update retries ([8c0a424b](https://github.com/zeebe-io/zeebe/commit/8c0a424b020651d653b5dedd2387b601b037ff5a))
  *  fix xor incident resolving ([ab592682](https://github.com/zeebe-io/zeebe/commit/ab5926822b3beaa404d1e8e008b80ed30e4462af))
  *  fix job state on cancel command ([024aafe3](https://github.com/zeebe-io/zeebe/commit/024aafe3152bac6605ef4526b3fa97e59fccee6c))
* **clients/java:**
  *  dont break cause chain ([be010d0e](https://github.com/zeebe-io/zeebe/commit/be010d0e0fcd898a91a5456cbe49d2912ccb34bd))
  *  fix default job poll interval and message ttl ([ab714eaa](https://github.com/zeebe-io/zeebe/commit/ab714eaaa7265d01c8da4bc861490fa512de6082))
* **exporters/elasticsearch:**  delayed flush should ignore bulk size ([beb15efc](https://github.com/zeebe-io/zeebe/commit/beb15efc2a7fa9c181cb9d7de017d93e27bccdff))

#### Features

* **bpmn-model:**
  *  enable non-interrupting time cycle boundary events ([bcf57f5e](https://github.com/zeebe-io/zeebe/commit/bcf57f5eba3dad93fe2ef8bc99926841f1d2624b))
  *  enable interrupting message boundary events ([ff1bddcd](https://github.com/zeebe-io/zeebe/commit/ff1bddcd44386f15a081139af197950b45d85588))
  *  enable interrupting timer boundary events ([edb345d1](https://github.com/zeebe-io/zeebe/commit/edb345d1138dc37d555f882ea99e02e1b5488f5e))
* **broker-core:**
  *  add support for event-based gateway ([425d6ca4](https://github.com/zeebe-io/zeebe/commit/425d6ca421cab2c09d1ba7cd8d41cb9ceb6ff16e))
  *  add support for interrupting message boundary events ([ea442ee9](https://github.com/zeebe-io/zeebe/commit/ea442ee9166dd8759b4880060efb5f176136279c))
  *  add job error message to failed jobs ([7baff1b7](https://github.com/zeebe-io/zeebe/commit/7baff1b79e97b3e60dd33c71100141535ddc66ba))
  *  impl new incident concept ([2a26ff58](https://github.com/zeebe-io/zeebe/commit/2a26ff58fc2b69a7d56d4862d5f59ec8ce87a4b6))
  *  add support for interrupting timer boundary events ([910b7b78](https://github.com/zeebe-io/zeebe/commit/910b7b78ba8167f2d1faec727e1f1cb21178f89c))
* **clients/go:**
  *  add resolve incident command ([e1a850db](https://github.com/zeebe-io/zeebe/commit/e1a850db1fe5023f1669a3555c2a0e7ff3cf6064))
  *  add error message to fail job command ([32bc691d](https://github.com/zeebe-io/zeebe/commit/32bc691db77a884ce5f93138059e84ef434c71bc))
* **clients/java:**  add resolve incident command ([25c1df38](https://github.com/zeebe-io/zeebe/commit/25c1df38a834032036cfbff77d38b3962062c13d))
* **clients/zbctl:**
  *  add resolve incident command ([3360289b](https://github.com/zeebe-io/zeebe/commit/3360289bb945c876e8a68d9684f0ac68934d376e))
  *  add fail job error message flag ([83269d8c](https://github.com/zeebe-io/zeebe/commit/83269d8cfbb50b09940860692d7f2c4085ad311e))
  *  implement publish message command ([1abca40a](https://github.com/zeebe-io/zeebe/commit/1abca40a7a96b9c7b92662bc35a74b4252f95771))
* **gateway:**  add incident resolve request to gateway ([e2eca8d2](https://github.com/zeebe-io/zeebe/commit/e2eca8d21c94ff82390eb2c9e24a2ad033db722d))



<a name="0.13.0"></a>
## 0.13.0 (2018-11-06)


#### Bug Fixes

* **broker-core:**
  *  exclusive split when default flow is first in XML ([75cd1539](https://github.com/zeebe-io/zeebe/commit/75cd1539c730440a87c2fefeaa96c253b5e856ac))
  *  add null check in job state controller ([10496ae7](https://github.com/zeebe-io/zeebe/commit/10496ae7b32f89e50c43896039fdc74a0c3f8b4d))
  *  correlate a message only once per wf instance ([892357cc](https://github.com/zeebe-io/zeebe/commit/892357cc35dd21d4d50c27ecf3edb5005f9d9809))
  *  fix concurrency problems with request metadata ([34b6b6fa](https://github.com/zeebe-io/zeebe/commit/34b6b6fa28e4552bfddf38f1c1e45457bb7a08ca))
* **exporters/elasticsearch:**  use correct index delimiter in root template ([e6c62be8](https://github.com/zeebe-io/zeebe/commit/e6c62be8df476cbd55ac5be0673633f4f35b3ec0))
* **gateway:**  use resource type provided in request instead of detecting ([9fbaccb5](https://github.com/zeebe-io/zeebe/commit/9fbaccb5965b211db6716ee8b2e1a81741708aa6)))

#### Breaking Changes

* **gateway:**  use resource type provided in request instead of detecting ([9fbaccb5](https://github.com/zeebe-io/zeebe/commit/9fbaccb5965b211db6716ee8b2e1a81741708aa6))

#### Features

* **broker-core:**
  *  add debug http exporter ([ef2d0203](https://github.com/zeebe-io/zeebe/commit/ef2d02035c09bdc4577551651aace7a20fb07450))
  *  handle intermediate timer catch event ([62111c35](https://github.com/zeebe-io/zeebe/commit/62111c3549357401bf20c1dec8620375837ebafe))
* **clients/go:**
  *  implement polling job worker ([09a21788](https://github.com/zeebe-io/zeebe/commit/09a21788b6c794c7ae1448230edfb0adc83d69ba))
  *  implement list workflows and get workflow ([5169ac27](https://github.com/zeebe-io/zeebe/commit/5169ac27c6448d083540dc7fe92c26a40b315711))
* **clients/zbctl:**
  *  add create worker command ([68d17600](https://github.com/zeebe-io/zeebe/commit/68d176008a9d22ad3e703bc43f1a241698ee47af))
  *  implement list workflows and get workflow ([429bdc47](https://github.com/zeebe-io/zeebe/commit/429bdc472de68d55ebdf43b7ad8bdc52d0ddd525))
  *  allow to configure the address to connect to ([0a3a4010](https://github.com/zeebe-io/zeebe/commit/0a3a401059b5f8128f9c746f9fa0b403f1ff6875))
* **dist:**  add standalone gateway script and configuration ([df212f12](https://github.com/zeebe-io/zeebe/commit/df212f12492d187d749382b67da346b29f4a694d))
* **gateway:**  add gateway configuration readable from toml file ([08b66441](https://github.com/zeebe-io/zeebe/commit/08b6644132e41b398d850408a35de78dbf654f98))
* **gateway-protocol:**  expose cluster settings in gateway protocol ([0035d39d](https://github.com/zeebe-io/zeebe/commit/0035d39d1bd2c3dce577551d19394ba484f58ade))



<a name="0.12.1"></a>
## 0.12.1 (2018-10-26)


#### Bug Fixes

* **broker-core:**
  *  exclusive split when default flow is first in XML ([3c91aa1d](https://github.com/zeebe-io/zeebe/commit/3c91aa1dc4f4740f50c3661cd87d8d565fae8ef3))
  *  fix concurrency problems with request metadata ([85e26e92](https://github.com/zeebe-io/zeebe/commit/85e26e926d131f23e8e5d9a28fac3a1e8da0f367))
* **exporters/elasticsearch:**  use correct index delimiter in root template ([9572500a](https://github.com/zeebe-io/zeebe/commit/9572500a0c889028e9966d0b31941092f3789caa))



<a name="0.12.0"></a>
## 0.12.0 (2018-10-16)


#### Bug Fixes

* **bpmn-model:**
  *  do not return raw type on connectTo ([9b45432a](https://github.com/zeebe-io/zeebe/commit/9b45432afab2dcef7d69588e1bbe31a27dc44e59))
  *  return typed builders from move to methods ([3cb70e08](https://github.com/zeebe-io/zeebe/commit/3cb70e089263fd31fd4a8a089de8b04cbd4115f5))
* **broker-core:**
  *  fix persistence cache ([eebc90f4](https://github.com/zeebe-io/zeebe/commit/eebc90f48128d24dd32a4adb45f4a7eb0bc47d8c))
  *  remove message subscription completely ([573ea845](https://github.com/zeebe-io/zeebe/commit/573ea845dd44ddfd846f832ad73388eaaf39dd94))
  *  fix unstable test ([7982444b](https://github.com/zeebe-io/zeebe/commit/7982444bdc572948c3a0dba5c27b7d0dca63ae7e))
  *  fix recovery ([cee0d1a4](https://github.com/zeebe-io/zeebe/commit/cee0d1a44036c30149ca90558f475f4783f7cddb))
  *  fix offset assert in messages ([efa4d563](https://github.com/zeebe-io/zeebe/commit/efa4d5630767d8f6f7080f23d0c7f92dfcd7650e))
  *  fix reprcoessing of deployments ([8cfff928](https://github.com/zeebe-io/zeebe/commit/8cfff92855d9e17f5b581dfd435a8acf9eacba4d))
  *  set flow scope payload after output mapping ([30ef6d69](https://github.com/zeebe-io/zeebe/commit/30ef6d69d1c52e19e37701bc418d73cfdd25a2d2))
  *  fix state byte ordering ([c7b59c4b](https://github.com/zeebe-io/zeebe/commit/c7b59c4b6a8426ae2e95fc0b923c4b01261d9ecf))
  *  move standalone broker into dist ([a26bf9a3](https://github.com/zeebe-io/zeebe/commit/a26bf9a39c9ce3771e08efae9c8c31c19b546411))
  *  messages with same name and correlation key ([366022a7](https://github.com/zeebe-io/zeebe/commit/366022a74ae52ae85d84b2bf18bb8774e88a221b))
  *  find message subscription ([38bb023e](https://github.com/zeebe-io/zeebe/commit/38bb023eefba7cb5fe26600612c3367117af7bef))
  *  reliably activate jobs ([8947ebfb](https://github.com/zeebe-io/zeebe/commit/8947ebfba76244866338408fadef092006e48621))
  *  message stream processors work with multiple partitions ([585c3615](https://github.com/zeebe-io/zeebe/commit/585c36156b8bd1283be369ee271410abd72299c7))
  *  snapshot replication on leader change ([64a0ff72](https://github.com/zeebe-io/zeebe/commit/64a0ff72dcc2b641ca93ca0bb86b7e8ba296721c))
* **clients/go:**  add missing retries parameter to fail job command ([f772eb55](https://github.com/zeebe-io/zeebe/commit/f772eb55cae05537dc344b62dd302960d616bcca))
* **dispatcher:**  decrease total work ([8136cdef](https://github.com/zeebe-io/zeebe/commit/8136cdef28e4e9cc5ec08f8de2678153a7114211))
* **dist:**  remove semicolon from cfg ([e617f378](https://github.com/zeebe-io/zeebe/commit/e617f378f0585759f03f2e7d002d395883e16ac2))
* **exporter:**  add aliases to ES indices ([7e9fffef](https://github.com/zeebe-io/zeebe/commit/7e9fffef7160c9aecbddaf2495baca6386affef5))
* **gateway:**  use NonBlockingMemoryPool to avoid long timeouts ([17e2f0aa](https://github.com/zeebe-io/zeebe/commit/17e2f0aac92f8cc0f0c6133e3162d84824edb6c5))
* **job:**  rewirte job append ([3167d302](https://github.com/zeebe-io/zeebe/commit/3167d302ae107bae39d6926d30ef396fa582eebf))
* **logstreams:**  do not close twice ([9a075c74](https://github.com/zeebe-io/zeebe/commit/9a075c74090a7fbad8c6629074ca4c80f8c9fa2f))
* **raft:**  persist raft members list on every member change ([dfa958a8](https://github.com/zeebe-io/zeebe/commit/dfa958a849160f1a3b43eb0ba22938331e4de845))
* **scheduler:**  handle race condition where job is added to dropped queue ([3304862f](https://github.com/zeebe-io/zeebe/commit/3304862f6dc69ce797b9053e300e3535724fee5a))
* **transport:**  retry send message if channel is not open ([ebb718d3](https://github.com/zeebe-io/zeebe/commit/ebb718d3e6323eebbdd93de73d29f2273e8505b9))

#### Features

* **bpmn-model:**
  *  extensions for payload mapping ([a4732a2f](https://github.com/zeebe-io/zeebe/commit/a4732a2fd3f5e2c5b8173951ca8f1158b99aca36))
  *  validate supported elements and event definitions ([950038cf](https://github.com/zeebe-io/zeebe/commit/950038cfc4eccb373e9ed4c4937d6cb764f4baa0))
  *  support intermediate catch event and receive task ([6741b6f7](https://github.com/zeebe-io/zeebe/commit/6741b6f7fdac6173ebbefdc8c74c4804ba152d4c))
* **broker-core:**
  *  implicit parallel split ([4eff3a66](https://github.com/zeebe-io/zeebe/commit/4eff3a660a46f83a1543cd3d5e452a2496052623))
  *  complete job by key ([5835cf2f](https://github.com/zeebe-io/zeebe/commit/5835cf2f69c6039d8eb4b36d15f8db35a39e6d95))
  *  fail jobs by key and retries ([1c08141e](https://github.com/zeebe-io/zeebe/commit/1c08141e4548b118c93ec34df50735fa1e34d115))
  *  update job retries by key ([d15bfd50](https://github.com/zeebe-io/zeebe/commit/d15bfd50f17a3c315e638caa4861bb6be603cf6b))
  *  payload update with key and payload only ([afa99c45](https://github.com/zeebe-io/zeebe/commit/afa99c45d964762de9348ff6b3828b2135ead938))
  *  workflow instance cancellation by key ([c4c78479](https://github.com/zeebe-io/zeebe/commit/c4c78479c9b39bd8864a86b8a0d14a493d0ea8fb))
  *  merge token payloads on scope completion ([9d42e78a](https://github.com/zeebe-io/zeebe/commit/9d42e78ad636640c7c08941ea58ffad00a6e34c4))
  *  merge payloads on parallel gateway merge ([2c7370e3](https://github.com/zeebe-io/zeebe/commit/2c7370e3a00059878955f768e0caedea9fc04d4c))
  *  introduce message state controller ([92ed1264](https://github.com/zeebe-io/zeebe/commit/92ed126478d03b7906f713dee0119712c5480813))
  *  BPMN merging parallel gateway ([83743595](https://github.com/zeebe-io/zeebe/commit/83743595ddec7fdfd7161ddc00e3792456ccdfc6))
  *  install partitions via cfg ([c961adf7](https://github.com/zeebe-io/zeebe/commit/c961adf7b91d851c4d64417646101baa190fc99a))
  *  create partitions matrix ([497a2898](https://github.com/zeebe-io/zeebe/commit/497a2898eadf3502d4ef09be04d55f8912faa36e))
  *  forking parallel gateway ([d40aa3ec](https://github.com/zeebe-io/zeebe/commit/d40aa3eca31099ab7207bc875fe934efeb49847c))
  *  add debug exporter ([5e8ca251](https://github.com/zeebe-io/zeebe/commit/5e8ca2516a71a6a5976880288b37e22dc30af3e3))
  *  create partition ids in cluster cfg ([039a5798](https://github.com/zeebe-io/zeebe/commit/039a57981c202bbcda705b4870d401a26ef150a0))
  *  allow to set data directories as environment variable ([3eedf6ea](https://github.com/zeebe-io/zeebe/commit/3eedf6ead00790844f1d5106418c3406f58dee8a))
  *  allow to set initial contact points as environment variable ([ab7cfda6](https://github.com/zeebe-io/zeebe/commit/ab7cfda620e962a433c0bdc51eba8bb907b5932a))
  *  allow to set host as environment variable ([b8f5131e](https://github.com/zeebe-io/zeebe/commit/b8f5131ece978edca79010dd31d33f9ad6e754ba))
  *  add exporter manager service ([f6f71d0b](https://github.com/zeebe-io/zeebe/commit/f6f71d0b066b8df729ffeb951f5b2790f262dfc1))
  *  add node id to configuration ([137c5621](https://github.com/zeebe-io/zeebe/commit/137c5621df9f0708511d0fb0ca168b1a17244259))
  *  correlate message resilient ([0f850910](https://github.com/zeebe-io/zeebe/commit/0f850910070424b0cccb989ed8d6c400f6e5fc9a))
  *  open a message subscription when a receive task is entered ([eec02854](https://github.com/zeebe-io/zeebe/commit/eec02854febc592868a96affff5e96b15694762b))
  *  open message subscription resilient ([816e2c0c](https://github.com/zeebe-io/zeebe/commit/816e2c0c90ecfcc6214153b744dda2404e200229))
  *  publish message with TTL ([de7d7604](https://github.com/zeebe-io/zeebe/commit/de7d7604d7f92dfd7ad0e0999b1322dd3e705977))
  *  embedded subprocess ([e54c7070](https://github.com/zeebe-io/zeebe/commit/e54c7070790a8999d05ff62e1984cb487e603fca))
  *  correlate a message to all subscriptions ([60fd1ae1](https://github.com/zeebe-io/zeebe/commit/60fd1ae1a8df080d3cc4c53269aae4b86547035e))
  *  open message subscription when catch event is entered ([9223947d](https://github.com/zeebe-io/zeebe/commit/9223947dbda91c97ac5a49da889e51133b073bdc))
  *  a message can be published idempotent ([dafc5294](https://github.com/zeebe-io/zeebe/commit/dafc529448e0681412383805d4381915b4456a41))
  *  a message can be published ([ac43219d](https://github.com/zeebe-io/zeebe/commit/ac43219db4d1c9542d0b88b06172d8ae3efeb62a))
  *  add port offset network configuration parameter ([3e5755d9](https://github.com/zeebe-io/zeebe/commit/3e5755d9f1fb1186ed5fe17d4783493783814e55))
  *  handle fetch-created-topics request ([1a20e311](https://github.com/zeebe-io/zeebe/commit/1a20e31178cc8e7abbb7b8ad8f264f5394797205))
  *  implement batch job activation ([5f3920ab](https://github.com/zeebe-io/zeebe/commit/5f3920ab669fa85d8324345a5e32dabb73c64c58))
  *  make keys global unique ([47053f38](https://github.com/zeebe-io/zeebe/commit/47053f382b18e8420a4fa68f725254668911f424))
  *  migrate instance index to RocksDb ([23a5d036](https://github.com/zeebe-io/zeebe/commit/23a5d036bf100de68477ddf5313a7a658569cdfa))
  *  migrate workflow cache ([0ed3275d](https://github.com/zeebe-io/zeebe/commit/0ed3275dee1e8e585f88e004dc054054760867c3))
  *  migrate workflow repository ([5433844e](https://github.com/zeebe-io/zeebe/commit/5433844e3347260dc0af5aa2908f4a135f42d8f4))
  *  configure cluster via cfg ([3d5e6271](https://github.com/zeebe-io/zeebe/commit/3d5e6271aae1ff7f80b862fe5b348cca4f1bd662))
  *  push deployment to remaining partitions ([38c699e5](https://github.com/zeebe-io/zeebe/commit/38c699e5bcf17c767e9c941273e1bf35d1ddb00c))
  *  change zeebe ports ([c0bd61c0](https://github.com/zeebe-io/zeebe/commit/c0bd61c095ad6e2fa0ad5529733f49d97dc9a252))
  *  migrates JobInstanceStreamProcessor to use RocksDB for state ([87182d3c](https://github.com/zeebe-io/zeebe/commit/87182d3cdc841a62175afd17a482f38d5169a8cd))
  *  integrates RocksDB as state backend for stream processors ([53ff0b5d](https://github.com/zeebe-io/zeebe/commit/53ff0b5d3d57e8dcc38ffd7c45c6d1f76a785da1))
* **clients/go:**
  *  implement activate jobs command ([2e16bea6](https://github.com/zeebe-io/zeebe/commit/2e16bea66387fcbb1926a9771683a25092e8da68))
  *  implement update job retries ([b3b763b3](https://github.com/zeebe-io/zeebe/commit/b3b763b33e858c1994697013fc401725770d34dc))
  *  implement fail job ([dcc1860f](https://github.com/zeebe-io/zeebe/commit/dcc1860fc50ff59b7d40b8d4aef4bc5523fe344b))
  *  implement complete job ([adb698e3](https://github.com/zeebe-io/zeebe/commit/adb698e375c587be1f7f49bc8f1dd6bee390678d))
  *  implement update payload ([258e1eac](https://github.com/zeebe-io/zeebe/commit/258e1eac1d8855bab7a61b7e6ebbfd7f26bc2ad4))
  *  Added simple golang client with health check ([74373755](https://github.com/zeebe-io/zeebe/commit/74373755974c20431204548f5d34ec5b82637dcc))
  *  Added automatic generation of Golang proto code ([5ff13ae2](https://github.com/zeebe-io/zeebe/commit/5ff13ae2e39aa9379ede2357748330e1f76c48fd))
  *  Added cancel workflow instance ([4838572d](https://github.com/zeebe-io/zeebe/commit/4838572df42cdadd69943d6154b2e5ec607a3bab))
  *  Added create job rpc on golang client ([725ce609](https://github.com/zeebe-io/zeebe/commit/725ce6097f6a0fcf912b2166b3712d5b6be2a4ab))
  *  Added golang client and fixed tests ([3bbd7cfc](https://github.com/zeebe-io/zeebe/commit/3bbd7cfc20a615624e7596b0552f65be13e456ea))
  *  Added publish message rpc on golang client ([5169ddf0](https://github.com/zeebe-io/zeebe/commit/5169ddf07244f333da8c1b3b7d4dca1ea0a9813a))
* **clients/java:**
  *  publish message with java client ([aafd8ba3](https://github.com/zeebe-io/zeebe/commit/aafd8ba33ce52a53d5df95dbe652991d4030bdcf))
  *  Java client switched to use client stub ([8e4a0bcc](https://github.com/zeebe-io/zeebe/commit/8e4a0bcce379f749ea68886d5c4f4fe470f5f989))
  *  implement polling job workers ([1134fc7d](https://github.com/zeebe-io/zeebe/commit/1134fc7dcc8c116c6fbfe3b93ebe095d36e8c531))
  *  implement get workflow and list workflows ([764398a1](https://github.com/zeebe-io/zeebe/commit/764398a142c7fa01f11dc4fef731e81b13ac6c32))
  *  complete job by key ([8030a88c](https://github.com/zeebe-io/zeebe/commit/8030a88c9adc42946d04e42cf8e041c91c742ffd))
  *  fail job with key and retries ([7f66d441](https://github.com/zeebe-io/zeebe/commit/7f66d44153f957effceeb19f2ecf2e9ed40678a0))
  *  update job retries by key ([434b6364](https://github.com/zeebe-io/zeebe/commit/434b63647fd606b4f2df674744e24cbd19d85234))
  *  update payload request ([468002a2](https://github.com/zeebe-io/zeebe/commit/468002a23d2321f08627ed1abbd49f21f99ac063))
  *  cancel workflow instance by key ([314ef859](https://github.com/zeebe-io/zeebe/commit/314ef859134a4dd9e3f6ea653bdd2f965a272814))
  *  create workflow instance request ([edcfbb02](https://github.com/zeebe-io/zeebe/commit/edcfbb02743566cd4b7ede7643082237db247f0f))
  *  add create job request ([c45fc3d1](https://github.com/zeebe-io/zeebe/commit/c45fc3d1b23f2e427cdb22786c670f14cd2e45a0))
* **clients/zbctl:**
  *  implement key based commands ([859f13f7](https://github.com/zeebe-io/zeebe/commit/859f13f70f08b856bef65a0e41f4fcd120aa89c0))
  *  add command to generate shell completion ([4d0163d9](https://github.com/zeebe-io/zeebe/commit/4d0163d928fd1b47e61ec5ab206dfe5a6df99171))
  *  Added zbctl with create instance, job, deploy and status commands ([fe9672a6](https://github.com/zeebe-io/zeebe/commit/fe9672a608e7872f028db55502934cef9d61f422))
* **dist:**  add new gossip config prop ([a5dc8447](https://github.com/zeebe-io/zeebe/commit/a5dc844797fa7ad93f69013472d9004ceed06eb9))
* **documentation:**
  *  parallel gateway ([121446b9](https://github.com/zeebe-io/zeebe/commit/121446b9919753f6dd93e26d9babbf22a55f7e47))
  *  overview of BPMN coverage ([2d11dcf6](https://github.com/zeebe-io/zeebe/commit/2d11dcf626b403de4bfd1b4c354d0952bad3fdf5))
  *  BPMN sub process ([ce73e00a](https://github.com/zeebe-io/zeebe/commit/ce73e00a08762a99fbdda3f586745af85b5e720b))
* **exporters:**
  *  add elasticsearch exporter ([12a70dbd](https://github.com/zeebe-io/zeebe/commit/12a70dbd464214fb9e36d222989305362874ba8c))
  *  adds stream processor to export records ([3752034a](https://github.com/zeebe-io/zeebe/commit/3752034af9368e66326d2d7368a79534ffab9b6a))
  *  load, configure, and validate exporters ([07bff107](https://github.com/zeebe-io/zeebe/commit/07bff10739a2d6980777519e6e67b04a70cbcac1))
  *  introduce new zb-exporter module ([0aab5e77](https://github.com/zeebe-io/zeebe/commit/0aab5e77813fb82757bc177f5eff35c792698387))
  *  adds exporter documentation ([9a8a9a0b](https://github.com/zeebe-io/zeebe/commit/9a8a9a0b0bc1e0a29fbf34e8d8d84a32a9d981ae))
  *  add AssertJ asserts for exporter records ([c16d3341](https://github.com/zeebe-io/zeebe/commit/c16d33418ea70c8ef981559be9a2136ce24bffff))
* **gateway:**
  *  implement activate jobs rpc call ([06f4e463](https://github.com/zeebe-io/zeebe/commit/06f4e463efd3ca1be67056660f12abd4ad7867d8))
  *  implement list workflows and get worklow ([0e84e7e4](https://github.com/zeebe-io/zeebe/commit/0e84e7e4a5386c8707120dc0b2227bcb82b769d2))
  *  cancel workflow instance ([e1d0b6ca](https://github.com/zeebe-io/zeebe/commit/e1d0b6ca779e5737c3e4145b4f12725536008da7))
  *  deploy workflow on java and go ([e5afa87a](https://github.com/zeebe-io/zeebe/commit/e5afa87a7fdb15febc470f9bc51d0399daa2de62))
  *  Added all needed infrastructure for gateway ([0ab54eba](https://github.com/zeebe-io/zeebe/commit/0ab54eba82d6e9987ecce11d1cea5c825437da23))
  *  expose scope instance key ([a8954fa4](https://github.com/zeebe-io/zeebe/commit/a8954fa439cb062acc65411296d94d588e510163))
  *  publish a message via Java Client ([96f4f84e](https://github.com/zeebe-io/zeebe/commit/96f4f84ee3c0a49e4350888ae359645566b4485f))
* **gateway-protocol:**  add ListWorkflows and GetWorkflow methods ([ffdc1098](https://github.com/zeebe-io/zeebe/commit/ffdc109897af4b4e42dfe09ad77812e5a09d1fac))
* **gossip:**  send sync request repeatedly ([ae9373ee](https://github.com/zeebe-io/zeebe/commit/ae9373ee85e9d7c4824ca5560bb8bbeb77602a2d))
* **json-path:**
  *  non-strict mapping extraction ([a116e60f](https://github.com/zeebe-io/zeebe/commit/a116e60fce82a18da75fd2c2d6667641ee878d5b))
  *  new mapping type to collect a result in an array ([eadd29c1](https://github.com/zeebe-io/zeebe/commit/eadd29c125f83661993c88351a1bc6cfa1604681))
* **logstreams:**  expose rocksb internal api ([07df1302](https://github.com/zeebe-io/zeebe/commit/07df130275641a7b6cdb1035878671fbcc312bf0))
* **msg-pack:**  merge multiple documents ([504ce125](https://github.com/zeebe-io/zeebe/commit/504ce125dc921c0f30ada33aa66b1208689dd93e))
* **transport:**  add endpoint registry ([b24b6ff5](https://github.com/zeebe-io/zeebe/commit/b24b6ff5c5d42a8801c008fbb4e52982c4fe30ac))
