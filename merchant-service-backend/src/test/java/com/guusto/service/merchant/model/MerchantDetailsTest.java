package com.guusto.service.merchant.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MerchantDetailsTest {

    private MerchantDetails merchantDetails;

    @BeforeEach
    public void init() {
        merchantDetails = new MerchantDetails(1L, "Amazon", "USA", "https://www.amazon.com/", "Online & In-store");
    }


    @Test
    void getId() {
        assertEquals(1L, merchantDetails.getId());
    }

    @Test
    void getName() {
        assertEquals("Amazon", merchantDetails.getName());
    }

    @Test
    void getCountry() {
        assertEquals("USA", merchantDetails.getCountry());
    }

    @Test
    void getWebsiteUrl() {
        assertEquals("https://www.amazon.com/", merchantDetails.getWebsiteUrl());
    }

    @Test
    void getPlatforms() {
        assertEquals("Online & In-store", merchantDetails.getPlatforms());
    }

    @Test
    void setId() {
        merchantDetails.setId(1l);
        assertEquals(1L, merchantDetails.getId());
    }

    @Test
    void setName() {
        merchantDetails.setName("Amazon");
        assertEquals("Amazon", merchantDetails.getName());
    }

    @Test
    void setCountry() {
        merchantDetails.setCountry("USA");
        assertEquals("USA", merchantDetails.getCountry());
    }

    @Test
    void setWebsiteUrl() {
        merchantDetails.setWebsiteUrl("https://www.amazon.com/");
        assertEquals("https://www.amazon.com/", merchantDetails.getWebsiteUrl());
    }

    @Test
    void setPlatforms() {
        merchantDetails.setPlatforms("Online & In-store");
        assertEquals("Online & In-store", merchantDetails.getPlatforms());
    }

    @Test
    void builder() {
        MerchantDetails obj = MerchantDetails.builder().id(1L).name("Amazon").country("USA").websiteUrl("https://www.amazon.com/").platforms("Online & In-store").build();
        assertEquals(merchantDetails.toString(), obj.toString());
    }
}