package com.springtutorial.firstspring.helper;

import com.springtutorial.firstspring.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.sql.*;
import java.util.ArrayList;

@Component
public class ProductQuery {

    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPassword;

    private final static Logger logger = LogManager.getLogger("shop");

    private ResultSet getDatabaseInfo(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        logger.info("Connected to the database");
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ArrayList<Product> getQuery(String query) throws SQLException {
        ResultSet resultSet = this.getDatabaseInfo(query);
        ArrayList<Product> list = new ArrayList<>();
        while(resultSet.next()){
            Product product = new Product();
            product.setId(resultSet.getInt(1));
            product.setName(resultSet.getString(2));
            product.setQuantity(resultSet.getInt(3));
            product.setPrice(resultSet.getDouble(4));
            product.setAddress(resultSet.getString(5));
            product.setAvailableOnline(resultSet.getBoolean(6));
            product.setLastRestock(resultSet.getTimestamp(7));
            list.add(product);
        }
        return list;
    }
}
