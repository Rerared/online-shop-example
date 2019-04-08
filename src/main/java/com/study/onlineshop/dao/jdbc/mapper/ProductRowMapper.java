package com.study.onlineshop.dao.jdbc.mapper;

import com.study.onlineshop.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProductRowMapper {
    // id, name, price
    public Product mapRow(ResultSet resultSet) throws SQLException {
        Product product = new Product();

        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));

        return product;
    }
}
