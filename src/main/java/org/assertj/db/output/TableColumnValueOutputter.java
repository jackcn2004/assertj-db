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
package org.assertj.db.output;

import org.assertj.db.type.Column;
import org.assertj.db.type.Table;
import org.assertj.db.type.Value;

/**
 * Output methods for a value in a {@link Column} of a {@link Table}.
 *
 * @author Régis Pouiller
 *
 */
public class TableColumnValueOutputter
        extends
        AbstractColumnValueOutputter<Table, TableOutputter, TableColumnOutputter, TableColumnValueOutputter, TableRowOutputter, TableRowValueOutputter> {

  /**
   * Constructor.
   *
   * @param origin The assertion of {@link org.assertj.db.navigation.origin.Origin}.
   * @param value The value to assert.
   */
  public TableColumnValueOutputter(TableColumnOutputter origin, Value value) {
    super(TableColumnValueOutputter.class, origin, value);
  }
}