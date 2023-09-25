package com.springtutorial.firstspring.service;

import com.springtutorial.firstspring.model.Product;
import com.springtutorial.firstspring.helper.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    ProductQuery productQuery;
    public ArrayList<Product> getProductsQuantity() throws SQLException {
        return productQuery.getQuery("select * from product");
    }

    public ArrayList<Product> getProductId(String id) throws SQLException {
        return productQuery.getQuery("select * from product where id = " + id);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public ArrayList<Product> getFilteredProducts( Map<String, String> parameters ) throws SQLException {
        String message = "";
        Set<Map.Entry<String,String>> temp = parameters.entrySet();
        Iterator<Map.Entry<String,String>> iterator = temp.iterator();
        while(iterator.hasNext()){
            String aux = iterator.next().toString();
            String[] parse = aux.split("=");
            if(!ProductService.isNumeric(parse[1])){
                message += parse[0] + " like '%" + parse[1] + "%'" + " AND ";
            } else {
                message += aux + " AND ";
            }
        }
        message = message.substring(0, message.length()-5);
        System.out.println(message);
        return productQuery.getQuery("select * from product where " + message);
    }
}
