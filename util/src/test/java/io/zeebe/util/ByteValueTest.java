/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.util;

import static io.zeebe.util.ByteUnit.BYTES;
import static io.zeebe.util.ByteUnit.GIGABYTES;
import static io.zeebe.util.ByteUnit.KILOBYTES;
import static io.zeebe.util.ByteUnit.MEGABYTES;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public final class ByteValueTest {
  @Test
  public void shouldParseValidStringValues() {
    assertThat(new ByteValue("10").getUnit()).isEqualTo(BYTES);
    assertThat(new ByteValue("10").getValue()).isEqualTo(10);

    assertThat(new ByteValue("11K").getUnit()).isEqualTo(KILOBYTES);
    assertThat(new ByteValue("11").getValue()).isEqualTo(11);

    assertThat(new ByteValue("12M").getUnit()).isEqualTo(MEGABYTES);
    assertThat(new ByteValue("12").getValue()).isEqualTo(12);

    assertThat(new ByteValue("13G").getUnit()).isEqualTo(GIGABYTES);
    assertThat(new ByteValue("13").getValue()).isEqualTo(13);
  }

  @Test
  public void shouldParseValidStringValuesCaseInsensitive() {
    assertThat(new ByteValue("11k").getUnit()).isEqualTo(KILOBYTES);
    assertThat(new ByteValue("12m").getUnit()).isEqualTo(MEGABYTES);
    assertThat(new ByteValue("13g").getUnit()).isEqualTo(GIGABYTES);
  }

  @Test
  public void shouldThrowOnInvalidUnit() {
    assertThatThrownBy(() -> new ByteValue("99f"))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("Illegal byte value");
  }

  @Test
  public void shouldConvertUnitBytes() {
    final long byteValue = 1_000_000_000L;
    assertThat(new ByteValue(byteValue, BYTES).toBytes()).isEqualTo(byteValue);
    assertThat(new ByteValue(byteValue, BYTES).toBytesValue())
        .isEqualTo(new ByteValue(byteValue, BYTES));
    assertThat(new ByteValue(byteValue, BYTES).toKilobytesValue())
        .isEqualTo(new ByteValue(byteValue / 1024, KILOBYTES));
    assertThat(new ByteValue(byteValue, BYTES).toMegabytesValue())
        .isEqualTo(new ByteValue(byteValue / (1024 * 1024), MEGABYTES));
    assertThat(new ByteValue(byteValue, BYTES).toGigabytesValue())
        .isEqualTo(new ByteValue(byteValue / (1024 * 1024 * 1024), GIGABYTES));
  }

  @Test
  public void shouldConvertUnitKilobytes() {
    final long kiloByteValue = 1_000_000L;
    assertThat(new ByteValue(kiloByteValue, KILOBYTES).toBytes()).isEqualTo(kiloByteValue * 1024);
    assertThat(new ByteValue(kiloByteValue, KILOBYTES).toBytesValue())
        .isEqualTo(new ByteValue(kiloByteValue * 1024, BYTES));
    assertThat(new ByteValue(kiloByteValue, KILOBYTES).toKilobytesValue())
        .isEqualTo(new ByteValue(kiloByteValue, KILOBYTES));
    assertThat(new ByteValue(kiloByteValue, KILOBYTES).toMegabytesValue())
        .isEqualTo(new ByteValue(kiloByteValue / 1024, MEGABYTES));
    assertThat(new ByteValue(kiloByteValue, KILOBYTES).toGigabytesValue())
        .isEqualTo(new ByteValue(kiloByteValue / (1024 * 1024), GIGABYTES));
  }

  @Test
  public void shouldConvertUnitMegabytes() {
    final long megaByteValue = 1_000L;
    assertThat(new ByteValue(megaByteValue, MEGABYTES).toBytes())
        .isEqualTo(megaByteValue * (1024 * 1024));
    assertThat(new ByteValue(megaByteValue, MEGABYTES).toBytesValue())
        .isEqualTo(new ByteValue(megaByteValue * (1024 * 1024), BYTES));
    assertThat(new ByteValue(megaByteValue, MEGABYTES).toKilobytesValue())
        .isEqualTo(new ByteValue(megaByteValue * 1024, KILOBYTES));
    assertThat(new ByteValue(megaByteValue, MEGABYTES).toMegabytesValue())
        .isEqualTo(new ByteValue(megaByteValue, MEGABYTES));
    assertThat(new ByteValue(megaByteValue, MEGABYTES).toGigabytesValue())
        .isEqualTo(new ByteValue(megaByteValue / 1024, GIGABYTES));
  }

  @Test
  public void shouldConvertUnitGigabytes() {
    final long gigaBytes = 100L;
    assertThat(new ByteValue(gigaBytes, GIGABYTES).toBytes())
        .isEqualTo(gigaBytes * (1024 * 1024 * 1024));
    assertThat(new ByteValue(gigaBytes, GIGABYTES).toBytesValue())
        .isEqualTo(new ByteValue(gigaBytes * (1024 * 1024 * 1024), BYTES));
    assertThat(new ByteValue(gigaBytes, GIGABYTES).toKilobytesValue())
        .isEqualTo(new ByteValue(gigaBytes * (1024 * 1024), KILOBYTES));
    assertThat(new ByteValue(gigaBytes, GIGABYTES).toMegabytesValue())
        .isEqualTo(new ByteValue(gigaBytes * 1024, MEGABYTES));
    assertThat(new ByteValue(gigaBytes, GIGABYTES).toGigabytesValue())
        .isEqualTo(new ByteValue(gigaBytes, GIGABYTES));
  }

  @Test
  public void shouldParseToString() {
    final ByteValue value = new ByteValue(71, ByteUnit.KILOBYTES);

    assertThat(new ByteValue(value.toString())).isEqualTo(value);
  }

  @Test
  public void shouldNormalizeBytesValue() {
    assertThat(ByteValue.ofBytes(128)).isEqualTo(ByteValue.ofBytes(128));
    assertThat(ByteValue.ofBytes(1023)).isEqualTo(ByteValue.ofBytes(1023));
    assertThat(ByteValue.ofBytes(1024)).isEqualTo(ByteValue.ofKilobytes(1));
    assertThat(ByteValue.ofBytes(512 * 1024)).isEqualTo(ByteValue.ofKilobytes(512));
    assertThat(ByteValue.ofBytes(1024 * 1024)).isEqualTo(ByteValue.ofMegabytes(1));
    assertThat(ByteValue.ofBytes(64 * 1024 * 1024)).isEqualTo(ByteValue.ofMegabytes(64));
    assertThat(ByteValue.ofBytes(1024 * 1024 * 1024)).isEqualTo(ByteValue.ofGigabytes(1));
    assertThat(ByteValue.ofBytes(4L * 1024 * 1024 * 1024)).isEqualTo(ByteValue.ofGigabytes(4));
  }

  @Test
  public void shouldNormalizeValue() {
    assertThat(ByteValue.ofBytes(512 * 1024).normalize()).isEqualTo(ByteValue.ofKilobytes(512));
    assertThat(ByteValue.ofKilobytes(64 * 1024).normalize()).isEqualTo(ByteValue.ofMegabytes(64));
    assertThat(ByteValue.ofMegabytes(4 * 1024).normalize()).isEqualTo(ByteValue.ofGigabytes(4));

    assertThat(ByteValue.ofBytes(128).normalize()).isEqualTo(ByteValue.ofBytes(128));
    assertThat(ByteValue.ofKilobytes(512).normalize()).isEqualTo(ByteValue.ofKilobytes(512));
    assertThat(ByteValue.ofMegabytes(128).normalize()).isEqualTo(ByteValue.ofMegabytes(128));
    assertThat(ByteValue.ofGigabytes(4).normalize()).isEqualTo(ByteValue.ofGigabytes(4));
  }
}
