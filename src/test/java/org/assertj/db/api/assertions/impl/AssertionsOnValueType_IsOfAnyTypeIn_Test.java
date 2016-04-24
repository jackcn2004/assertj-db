/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.db.api.assertions.impl;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.WritableAssertionInfo;
import org.assertj.db.api.TableAssert;
import org.assertj.db.common.AbstractTest;
import org.assertj.db.type.Table;
import org.assertj.db.type.ValueType;
import org.junit.Test;

import java.util.Locale;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Tests on {@link AssertionsOnValueType} class :
 * {@link AssertionsOnValueType#isOfAnyTypeIn(org.assertj.db.api.AbstractAssert, org.assertj.core.api.WritableAssertionInfo, org.assertj.db.type.Value, org.assertj.db.type.ValueType...)} method.
 *
 * @author Régis Pouiller
 *
 */
public class AssertionsOnValueType_IsOfAnyTypeIn_Test extends AbstractTest {

  /**
   * This method tests the {@code isOfAnyTypeIn} assertion method.
   */
  @Test
  public void test_is_of_any_of_types() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    TableAssert tableAssert2 = AssertionsOnValueType.isOfAnyTypeIn(tableAssert, info, getValue(null, "test"),
                                                                   ValueType.TEXT);
    Assertions.assertThat(tableAssert2).isSameAs(tableAssert);
    tableAssert2 = AssertionsOnValueType.isOfAnyTypeIn(tableAssert, info, getValue(null, "test"), ValueType.TEXT, ValueType.NUMBER);
    Assertions.assertThat(tableAssert2).isSameAs(tableAssert);
  }

  /**
   * This method should fail because the value is not of any of types.
   */
  @Test
  public void should_fail_because_value_is_not_of_any_of_types() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    try {
      AssertionsOnValueType.isOfAnyTypeIn(tableAssert, info, getValue(null, 8), ValueType.TEXT, ValueType.DATE);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                      + "Expecting:%n"
                                                      + "  <8>%n"
                                                      + "to be of type%n"
                                                      + "  <[TEXT, DATE]>%n"
                                                      + "but was of type%n"
                                                      + "  <NUMBER>"));
    }
    try {
      AssertionsOnValueType.isOfAnyTypeIn(tableAssert, info, getValue(null, null), ValueType.TEXT, ValueType.DATE);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting:%n"
                                                                    + "  <null>%n"
                                                                    + "to be of type%n"
                                                                    + "  <[TEXT, DATE]>%n"
                                                                    + "but was of type%n"
                                                                    + "  <NOT_IDENTIFIED>"));
    }
    try {
      AssertionsOnValueType.isOfAnyTypeIn(tableAssert, info, getValue(null, Locale.FRENCH), ValueType.TEXT, ValueType.DATE);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting:%n"
                                                                    + "  <fr>%n"
                                                                    + "to be of type%n"
                                                                    + "  <[TEXT, DATE]>%n"
                                                                    + "but was of type%n"
                                                                    + "  <NOT_IDENTIFIED> (java.util.Locale)"));
    }
  }

  /**
   * This method should fail because the value is a stringbuilder.
   */
  @Test
  public void should_fail_because_value_is_a_stringbuilder() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    try {
      AssertionsOnValueType.isOfAnyTypeIn(tableAssert, info, getValue(null, new StringBuilder("text")), ValueType.TEXT, ValueType.DATE);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting:%n"
                                                                    + "  <text>%n"
                                                                    + "to be of type%n"
                                                                    + "  <[TEXT, DATE]>%n"
                                                                    + "but was of type%n"
                                                                    + "  <NOT_IDENTIFIED> (java.lang.StringBuilder)"));
    }
  }
}
