#!/bin/sh -eux


export JAVA_TOOL_OPTIONS="$JAVA_TOOL_OPTIONS -XX:MaxRAMFraction=$((LIMITS_CPU))"

mvn -B -T$LIMITS_CPU -s ${MAVEN_SETTINGS_XML} -DskipTests clean com.mycila:license-maven-plugin:check com.coveo:fmt-maven-plugin:check org.apache.maven.plugins:maven-dependency-plugin:3.1.1:go-offline install -Pspotbugs,prepare-offline
