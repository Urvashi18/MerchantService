package com.guusto.service.merchant.rest;

import com.guusto.service.merchant.db.impl.JDBCMerchantRepository;
import com.guusto.service.merchant.model.MerchantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("merchants/")
public class SearchController {

    private final JDBCMerchantRepository repository;

    @Autowired
    public SearchController(JDBCMerchantRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = "application/json")
    public Collection<MerchantDetails> getAllMerchants(@RequestParam(required = false) String name, @RequestParam(required = false) String country) {
        return repository.getMerchants(Optional.ofNullable(name), Optional.ofNullable(country));
    }


    @GetMapping(value = "/countries", produces = "application/json")
    public Collection<String> getAllCountries() {
        return repository.getCountries();
    }


}
