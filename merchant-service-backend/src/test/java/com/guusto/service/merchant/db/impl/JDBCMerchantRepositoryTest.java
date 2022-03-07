package com.guusto.service.merchant.db.impl;

import com.guusto.service.merchant.mapper.MerchantMapper;
import com.guusto.service.merchant.db.Repository;
import com.guusto.service.merchant.model.MerchantDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@ExtendWith(MockitoExtension.class)
class JDBCMerchantRepositoryTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    Repository repo = new JDBCMerchantRepository();

    @Test
    void getAllMerchants() {
        List<MerchantDetails> mockList = new ArrayList<>();
        mockList.add(getSampleMerchant("Amazon", "Canada"));
        mockList.add(getSampleMerchant("AMA", "USA"));

        when(jdbcTemplate.query(
                Mockito.anyString(),
                Mockito.any(MerchantMapper.class)
        )).thenReturn(mockList);

        List<MerchantDetails> list = repo.getMerchants(Optional.empty(), Optional.empty());
        assertEquals(2, list.size());
        assertTrue(mockList.containsAll(list));
        assertTrue(list.containsAll(mockList));
    }

    @Test
    void getMerchantsFromCountry() {
        List<MerchantDetails> mockList = new ArrayList<>();
        mockList.add(getSampleMerchant("AMA", "USA"));

        when(jdbcTemplate.query(
                Mockito.anyString(),
                Mockito.any(MerchantMapper.class),
                Mockito.anyString()
        )).thenReturn(mockList);

        List<MerchantDetails> list = repo.getMerchants(Optional.empty(), Optional.of("USA"));
        assertEquals(1, list.size());
        assertTrue(mockList.containsAll(list));
        assertTrue(list.containsAll(mockList));
    }

    @Test
    void getMerchantsForSubstring() {
        List<MerchantDetails> mockList = new ArrayList<>();
        mockList.add(getSampleMerchant("AMA", "USA"));

        when(jdbcTemplate.query(
                Mockito.anyString(),
                Mockito.any(MerchantMapper.class),
                Mockito.anyString()
        )).thenReturn(mockList);

        List<MerchantDetails> list = repo.getMerchants(Optional.of("Am"), Optional.empty());
        assertEquals(1, list.size());
        assertTrue(mockList.containsAll(list));
        assertTrue(list.containsAll(mockList));
    }

    @Test
    void getMerchantsForSubstringAndCountry() {
        List<MerchantDetails> mockList = new ArrayList<>();
        mockList.add(getSampleMerchant("AMA", "USA"));

        when(jdbcTemplate.query(
                Mockito.anyString(),
                Mockito.any(MerchantMapper.class),
                Mockito.anyString(),
                Mockito.anyString()
        )).thenReturn(mockList);

        List<MerchantDetails> list = repo.getMerchants(Optional.of("Am"), Optional.of("USA"));
        assertEquals(1, list.size());
        assertTrue(mockList.containsAll(list));
        assertTrue(list.containsAll(mockList));
    }

    private MerchantDetails getSampleMerchant(String name, String country) {
        return MerchantDetails.builder().id(1L).name(name).country(country).build();
    }

}