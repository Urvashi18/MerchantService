package com.guusto.service.merchant.db;

import com.guusto.service.merchant.model.MerchantDetails;

import java.util.List;
import java.util.Optional;

public interface Repository {

    List<MerchantDetails> getMerchants(Optional<String> name, Optional<String> country);

    List<String> getCountries();

}
