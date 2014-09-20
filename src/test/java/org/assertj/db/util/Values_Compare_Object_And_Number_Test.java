package org.assertj.db.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.assertj.db.error.AssertJDBException;
import org.junit.Test;

/**
 * Tests on {@code compare} method for {@code Number}s.
 * 
 * @author Régis Pouiller
 * 
 */
public class Values_Compare_Object_And_Number_Test {

  /**
   * This method tests the {@code compare} method for {@code BigInteger}s.
   */
  @Test
  public void test_compare_for_biginteger() {
    assertThat(Values.compare(1, new BigInteger("1"))).isEqualTo(0);
    assertThat(Values.compare(new BigInteger("1"), new BigInteger("1"))).isEqualTo(0);
    assertThat(Values.compare(1, new BigInteger("2"))).isEqualTo(-1);
    assertThat(Values.compare(new BigInteger("1"), new BigInteger("2"))).isEqualTo(-1);
    assertThat(Values.compare(2, new BigInteger("1"))).isEqualTo(1);
    assertThat(Values.compare(new BigInteger("2"), new BigInteger("1"))).isEqualTo(1);
  }

  /**
   * This method should fail because the value ("-") can not be compared to a {@code BigInteger}.
   */
  @Test(expected = AssertJDBException.class)
  public void should_fail_because_value_can_not_be_compared_to_a_biginteger() {
    Values.compare("-", new BigInteger("1"));
  }

  /**
   * This method tests the {@code compare} method for {@code BigDecimal}s.
   */
  @Test
  public void test_compare_for_bigdecimal() {
    assertThat(Values.compare(1, new BigDecimal("1"))).isEqualTo(0);
    assertThat(Values.compare(new BigDecimal("1"), new BigDecimal("1"))).isEqualTo(0);
    assertThat(Values.compare(1, new BigDecimal("2"))).isEqualTo(-1);
    assertThat(Values.compare(new BigDecimal("1"), new BigDecimal("2"))).isEqualTo(-1);
    assertThat(Values.compare(2, new BigDecimal("1"))).isEqualTo(1);
    assertThat(Values.compare(new BigDecimal("2"), new BigDecimal("1"))).isEqualTo(1);
  }

  /**
   * This method should fail because the value ("-") can not be compared to a {@code BigDecimal}.
   */
  @Test(expected = AssertJDBException.class)
  public void should_fail_because_value_can_not_be_compared_to_a_bigdecimal() {
    Values.compare("-", new BigDecimal("1"));
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code Float}s.
   */
  @Test
  public void test_compare_for_other_and_float() {
    assertThat(Values.compare(1F, 1)).isEqualTo(0);
    assertThat(Values.compare(1F, 2)).isEqualTo(-1);
    assertThat(Values.compare(2F, 1)).isEqualTo(1);
    assertThat(Values.compare(1F, 1L)).isEqualTo(0);
    assertThat(Values.compare(1F, 2L)).isEqualTo(-1);
    assertThat(Values.compare(2F, 1L)).isEqualTo(1);
    assertThat(Values.compare(1F, 1F)).isEqualTo(0);
    assertThat(Values.compare(1F, 2F)).isEqualTo(-1);
    assertThat(Values.compare(2F, 1F)).isEqualTo(1);
    assertThat(Values.compare(1F, 1D)).isEqualTo(0);
    assertThat(Values.compare(1F, 2D)).isEqualTo(-1);
    assertThat(Values.compare(2F, 1D)).isEqualTo(1);
    assertThat(Values.compare(1.5F, 1.5F)).isEqualTo(0);
    assertThat(Values.compare(1.5F, 2.5F)).isEqualTo(-1);
    assertThat(Values.compare(2.5F, 1.5F)).isEqualTo(1);
    assertThat(Values.compare(1.5F, 1.5D)).isEqualTo(0);
    assertThat(Values.compare(1.5F, 2.5D)).isEqualTo(-1);
    assertThat(Values.compare(2.5F, 1.5D)).isEqualTo(1);
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code Double}s.
   */
  @Test
  public void test_compare_for_other_and_double() {
    assertThat(Values.compare(1D, 1)).isEqualTo(0);
    assertThat(Values.compare(1D, 2)).isEqualTo(-1);
    assertThat(Values.compare(2D, 1)).isEqualTo(1);
    assertThat(Values.compare(1D, 1L)).isEqualTo(0);
    assertThat(Values.compare(1D, 2L)).isEqualTo(-1);
    assertThat(Values.compare(2D, 1L)).isEqualTo(1);
    assertThat(Values.compare(1D, 1F)).isEqualTo(0);
    assertThat(Values.compare(1D, 2F)).isEqualTo(-1);
    assertThat(Values.compare(2D, 1F)).isEqualTo(1);
    assertThat(Values.compare(1D, 1D)).isEqualTo(0);
    assertThat(Values.compare(1D, 2D)).isEqualTo(-1);
    assertThat(Values.compare(2D, 1D)).isEqualTo(1);
    assertThat(Values.compare(1.5D, 1.5F)).isEqualTo(0);
    assertThat(Values.compare(1.5D, 2.5F)).isEqualTo(-1);
    assertThat(Values.compare(2.5D, 1.5F)).isEqualTo(1);
    assertThat(Values.compare(1.5D, 1.5D)).isEqualTo(0);
    assertThat(Values.compare(1.5D, 2.5D)).isEqualTo(-1);
    assertThat(Values.compare(2.5D, 1.5D)).isEqualTo(1);
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code BigInteger}s.
   */
  @Test
  public void test_compare_for_other_and_biginteger() {
    assertThat(Values.compare(new BigInteger("1"), 1)).isEqualTo(0);
    assertThat(Values.compare(new BigInteger("1"), 2)).isEqualTo(-1);
    assertThat(Values.compare(new BigInteger("2"), 1)).isEqualTo(1);
    assertThat(Values.compare(new BigInteger("1"), 1L)).isEqualTo(0);
    assertThat(Values.compare(new BigInteger("1"), 2L)).isEqualTo(-1);
    assertThat(Values.compare(new BigInteger("2"), 1L)).isEqualTo(1);
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code BigDecimal}s.
   */
  @Test
  public void test_compare_for_other_and_bigdecimal() {
    assertThat(Values.compare(new BigDecimal("1"), 1)).isEqualTo(0);
    assertThat(Values.compare(new BigDecimal("1"), 2)).isEqualTo(-1);
    assertThat(Values.compare(new BigDecimal("2"), 1)).isEqualTo(1);
    assertThat(Values.compare(new BigDecimal("1"), 1L)).isEqualTo(0);
    assertThat(Values.compare(new BigDecimal("1"), 2L)).isEqualTo(-1);
    assertThat(Values.compare(new BigDecimal("2"), 1L)).isEqualTo(1);
    assertThat(Values.compare(new BigDecimal("1"), 1F)).isEqualTo(0);
    assertThat(Values.compare(new BigDecimal("1"), 2F)).isEqualTo(-1);
    assertThat(Values.compare(new BigDecimal("2"), 1F)).isEqualTo(1);
    assertThat(Values.compare(new BigDecimal("1"), 1D)).isEqualTo(0);
    assertThat(Values.compare(new BigDecimal("1"), 2D)).isEqualTo(-1);
    assertThat(Values.compare(new BigDecimal("2"), 1D)).isEqualTo(1);
    assertThat(Values.compare(new BigDecimal("1.5"), 1.5F)).isEqualTo(0);
    assertThat(Values.compare(new BigDecimal("1.5"), 2.5F)).isEqualTo(-1);
    assertThat(Values.compare(new BigDecimal("2.5"), 1.5F)).isEqualTo(1);
    assertThat(Values.compare(new BigDecimal("1.5"), 1.5D)).isEqualTo(0);
    assertThat(Values.compare(new BigDecimal("1.5"), 2.5D)).isEqualTo(-1);
    assertThat(Values.compare(new BigDecimal("2.5"), 1.5D)).isEqualTo(1);
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code Byte}s.
   */
  @Test
  public void test_compare_for_other_and_byte() {
    assertThat(Values.compare((byte) 1, 1)).isEqualTo(0);
    assertThat(Values.compare((byte) 1, 2)).isEqualTo(-1);
    assertThat(Values.compare((byte) 2, 1)).isEqualTo(1);
    assertThat(Values.compare((byte) 1, 1L)).isEqualTo(0);
    assertThat(Values.compare((byte) 1, 2L)).isEqualTo(-1);
    assertThat(Values.compare((byte) 2, 1L)).isEqualTo(1);
    assertThat(Values.compare((byte) 1, 1F)).isEqualTo(0);
    assertThat(Values.compare((byte) 1, 2F)).isEqualTo(-1);
    assertThat(Values.compare((byte) 2, 1F)).isEqualTo(1);
    assertThat(Values.compare((byte) 1, 1D)).isEqualTo(0);
    assertThat(Values.compare((byte) 1, 2D)).isEqualTo(-1);
    assertThat(Values.compare((byte) 2, 1D)).isEqualTo(1);
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code Short}s.
   */
  @Test
  public void test_compare_for_other_and_short() {
    assertThat(Values.compare((short) 1, 1)).isEqualTo(0);
    assertThat(Values.compare((short) 1, 2)).isEqualTo(-1);
    assertThat(Values.compare((short) 2, 1)).isEqualTo(1);
    assertThat(Values.compare((short) 1, 1L)).isEqualTo(0);
    assertThat(Values.compare((short) 1, 2L)).isEqualTo(-1);
    assertThat(Values.compare((short) 2, 1L)).isEqualTo(1);
    assertThat(Values.compare((short) 1, 1F)).isEqualTo(0);
    assertThat(Values.compare((short) 1, 2F)).isEqualTo(-1);
    assertThat(Values.compare((short) 2, 1F)).isEqualTo(1);
    assertThat(Values.compare((short) 1, 1D)).isEqualTo(0);
    assertThat(Values.compare((short) 1, 2D)).isEqualTo(-1);
    assertThat(Values.compare((short) 2, 1D)).isEqualTo(1);
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code Integer}s.
   */
  @Test
  public void test_compare_for_other_and_integer() {
    assertThat(Values.compare((int) 1, 1)).isEqualTo(0);
    assertThat(Values.compare((int) 1, 2)).isEqualTo(-1);
    assertThat(Values.compare((int) 2, 1)).isEqualTo(1);
    assertThat(Values.compare((int) 1, 1L)).isEqualTo(0);
    assertThat(Values.compare((int) 1, 2L)).isEqualTo(-1);
    assertThat(Values.compare((int) 2, 1L)).isEqualTo(1);
    assertThat(Values.compare((int) 1, 1F)).isEqualTo(0);
    assertThat(Values.compare((int) 1, 2F)).isEqualTo(-1);
    assertThat(Values.compare((int) 2, 1F)).isEqualTo(1);
    assertThat(Values.compare((int) 1, 1D)).isEqualTo(0);
    assertThat(Values.compare((int) 1, 2D)).isEqualTo(-1);
    assertThat(Values.compare((int) 2, 1D)).isEqualTo(1);
  }

  /**
   * This method tests the {@code compare} method for another type of value and {@code Long}s.
   */
  @Test
  public void test_compare_for_other_and_long() {
    assertThat(Values.compare((long) 1, 1)).isEqualTo(0);
    assertThat(Values.compare((long) 1, 2)).isEqualTo(-1);
    assertThat(Values.compare((long) 2, 1)).isEqualTo(1);
    assertThat(Values.compare((long) 1, 1L)).isEqualTo(0);
    assertThat(Values.compare((long) 1, 2L)).isEqualTo(-1);
    assertThat(Values.compare((long) 2, 1L)).isEqualTo(1);
    assertThat(Values.compare((long) 1, 1F)).isEqualTo(0);
    assertThat(Values.compare((long) 1, 2F)).isEqualTo(-1);
    assertThat(Values.compare((long) 2, 1F)).isEqualTo(1);
    assertThat(Values.compare((long) 1, 1D)).isEqualTo(0);
    assertThat(Values.compare((long) 1, 2D)).isEqualTo(-1);
    assertThat(Values.compare((long) 2, 1D)).isEqualTo(1);
  }

  /**
   * This method should fail because the value ("-") can not be compared to a {@code Number}.
   */
  @Test(expected = AssertJDBException.class)
  public void should_fail_because_value_can_not_be_compared_to_a_number() {
    assertThat(Values.compare("-", 1));
  }

}
