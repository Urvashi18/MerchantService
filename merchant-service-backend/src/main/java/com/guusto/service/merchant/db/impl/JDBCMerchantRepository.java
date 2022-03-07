package com.guusto.service.merchant.db.impl;

import com.guusto.service.merchant.db.Repository;
import com.guusto.service.merchant.mapper.MerchantMapper;
import com.guusto.service.merchant.model.MerchantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class JDBCMerchantRepository implements Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final private String merchantTable = "Merchants";
    private RowMapper<MerchantDetails> merchantMapper = new MerchantMapper();

    @Override
    public List<MerchantDetails> getMerchants(Optional<String> name, Optional<String> country) {
        if (name.isPresent() && country.isPresent()) {
            return findByNameAndCountry(name.get(), country.get());
        } else if (name.isPresent()) {
            return findByName(name.get());
        } else if (country.isPresent()) {
            return findByCountry(country.get());
        }
        String mainQuery = "SELECT * from " + merchantTable;
        return jdbcTemplate.query(mainQuery, merchantMapper);
    }

    private List<MerchantDetails> findByNameAndCountry(String name, String country) {
        return jdbcTemplate.query("SELECT * from " + merchantTable + " where name LIKE ? and country = ?",
                merchantMapper, "%" + name + "%", country);
    }

    private List<MerchantDetails> findByName(String name) {
        return jdbcTemplate.query("SELECT * from " + merchantTable + " where name LIKE ? ",
                merchantMapper, "%" + name + "%");
    }

    private List<MerchantDetails> findByCountry(String country) {
        return jdbcTemplate.query("SELECT * from " + merchantTable + " where country = ?",
                merchantMapper, country);
    }

    @Override
    public List<String> getCountries() {
        return jdbcTemplate.queryForList("SELECT DISTINCT country from " + merchantTable, String.class);
    }
}