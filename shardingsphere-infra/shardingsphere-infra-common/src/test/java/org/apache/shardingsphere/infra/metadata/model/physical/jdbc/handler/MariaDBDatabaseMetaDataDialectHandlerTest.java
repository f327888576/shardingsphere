/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.metadata.model.physical.jdbc.handler;

import org.apache.shardingsphere.infra.database.type.dialect.MariaDBDatabaseType;
import org.apache.shardingsphere.sql.parser.sql.common.constant.QuoteCharacter;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public final class MariaDBDatabaseMetaDataDialectHandlerTest extends AbstractDatabaseMetaDataDialectHandlerTest {
    
    @Test
    public void assertGetSchema() throws SQLException {
        when(getConnection().getSchema()).thenReturn(DATABASE_NAME);
        String mariadbSchema = getSchema(new MariaDBDatabaseType());
        assertThat(mariadbSchema, is(DATABASE_NAME));
    }
    
    @Test
    public void assertFormatTableNamePattern() {
        String mariadbTableNamePattern = formatTableNamePattern(new MariaDBDatabaseType());
        assertThat(mariadbTableNamePattern, is(TABLE_NAME_PATTERN));
    }
    
    @Test
    public void assertGetQuoteCharacter() {
        QuoteCharacter mariadbQuoteCharacter = getQuoteCharacter(new MariaDBDatabaseType());
        assertThat(mariadbQuoteCharacter.getStartDelimiter(), is("`"));
        assertThat(mariadbQuoteCharacter.getEndDelimiter(), is("`"));
    }
}
