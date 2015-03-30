package org.assertj.db.api.assertions.impl;

import org.assertj.core.api.WritableAssertionInfo;
import org.assertj.db.api.TableAssert;
import org.assertj.db.type.Table;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Tests on {@link AssertionsOnColumnEquality} class :
 * {@link AssertionsOnColumnEquality#hasValuesEqualTo(org.assertj.db.api.AbstractAssert, org.assertj.core.api.WritableAssertionInfo, java.util.List, Boolean...)} method.
 *
 * @author Régis Pouiller
 *
 */
public class AssertionsOnColumnEquality_HasValuesEqualTo_Boolean_Test {

  /**
   * This method tests the {@code hasValuesEqualTo} assertion method.
   */
  @Test
  public void test_have_values_equal_to() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    List<Object> list = new ArrayList<Object>(Arrays.asList(true, false, null));
    TableAssert tableAssert2 = AssertionsOnColumnEquality.hasValuesEqualTo(tableAssert, info, list, Boolean.TRUE, Boolean.FALSE, null);
    assertThat(tableAssert2).isSameAs(tableAssert);
  }

  /**
   * This method should fail because the values are different.
   */
  @Test
  public void should_fail_because_values_are_different() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    List<Object> list = new ArrayList<Object>(Arrays.asList(false, false));
    try {
      AssertionsOnColumnEquality.hasValuesEqualTo(tableAssert, info, list, Boolean.TRUE, Boolean.FALSE);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      assertThat(e.getMessage()).isEqualTo("[description] \n"
                                           + "Expecting that the value at index 0:\n"
                                           + "  <false>\n"
                                           + "to be equal to: \n"
                                           + "  <true>");
    }
  }

  /**
   * This method should fail because one of the values is not a boolean.
   */
  @Test
  public void should_fail_because_one_value_is_not_a_boolean() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    List<Object> list = new ArrayList<Object>(Arrays.asList("other", false));
    try {
      AssertionsOnColumnEquality.hasValuesEqualTo(tableAssert, info, list, Boolean.TRUE, Boolean.FALSE);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      assertThat(e.getMessage()).isEqualTo("[description] \n"
                                           + "Expecting that the value at index 0:\n"
                                           + "  <\"other\">\n"
                                           + "to be of type\n"
                                           + "  <[BOOLEAN, NOT_IDENTIFIED]>\n"
                                           + "but was of type\n"
                                           + "  <TEXT>");
    }
  }

  /**
   * This method should fail because the number of values is different.
   */
  @Test
  public void should_fail_because_the_number_of_values_is_different() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    List<Object> list = new ArrayList<Object>(Arrays.asList(true, false));
    try {
      AssertionsOnColumnEquality.hasValuesEqualTo(tableAssert, info, list, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      assertThat(e.getMessage()).isEqualTo("[description] \n"
                                           + "Expecting size (number of rows) to be equal to :\n"
                                           + "   <3>\n"
                                           + "but was:\n"
                                           + "   <2>");
    }
  }
}
