package com.guusto.service.merchant.rest;

import com.guusto.service.merchant.db.Repository;
import com.guusto.service.merchant.db.impl.JDBCMerchantRepository;
import com.guusto.service.merchant.model.MerchantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("merchants/")
public class SearchController {

    private final Repository repository;

    @Autowired
    public SearchController(Repository repository) {
        this.repository = repository;
    }

    @CrossOrigin
    @GetMapping(produces = "application/json")
    public Collection<MerchantDetails> getAllMerchants(@RequestParam(required = false) String name, @RequestParam(required = false) String country) {
        return repository.getMerchants(Optional.ofNullable(name), Optional.ofNullable(country));
    }

    @CrossOrigin
    @GetMapping(value = "/countries", produces = "application/json")
    public Collection<String> getAllCountries() {
        return repository.getCountries();
    }


}
