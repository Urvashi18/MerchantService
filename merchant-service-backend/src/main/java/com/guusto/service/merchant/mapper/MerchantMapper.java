package com.guusto.service.merchant.mapper;

import com.guusto.service.merchant.model.MerchantDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MerchantMapper implements RowMapper<MerchantDetails> {
    @Override
    public MerchantDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return MerchantDetails.builder().id(rs.getLong("id")).name(rs.getString("name")).platforms(rs.getString("platforms"))
                .websiteUrl(rs.getString("websiteUrl")).country(rs.getString("country")).build();
    }
}
