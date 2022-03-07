package com.guusto.service.merchant.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MerchantDetails {
    private Long id;
    private String name;
    private String country;
    private String websiteUrl;
    private String platforms;
}
