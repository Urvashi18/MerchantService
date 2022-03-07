package com.guusto.service.merchant.mapper;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MerchantMapperTest {
    private final MerchantMapper mapper = new MerchantMapper();
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    void mappingSucceeds(){
        ResultSet test = Mockito.mock(ResultSet.class);
        try {
            assertNotNull(mapper.mapRow(test, 1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void nullResultSet() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            mapper.mapRow(null, 1);
        });
    }

    @Test
    void mappingFails() throws SQLException {
        ResultSet test = Mockito.mock(ResultSet.class);
        Mockito.when(test.getLong("id")).thenThrow(SQLException.class);
        Exception exception = assertThrows(SQLException.class, () -> {
            mapper.mapRow(test, 1);
        });
    }
}