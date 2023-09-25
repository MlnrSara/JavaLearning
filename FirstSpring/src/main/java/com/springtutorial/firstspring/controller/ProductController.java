package com.springtutorial.firstspring.controller;

import com.springtutorial.firstspring.model.Product;
import com.springtutorial.firstspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping
    @ResponseBody
    public ArrayList<Product> showQuery() throws SQLException {
        return productService.getProductsQuantity();
    }

    @GetMapping(value = "/product/{id}")
    public ArrayList<Product> showID(@PathVariable("id") String id) throws SQLException{
        return productService.getProductId(id);
    }

    @GetMapping(value = "/product/filter")
    public ArrayList<Product> filterQuery(@RequestParam Map< String,String > parameters) throws SQLException {
        return productService.getFilteredProducts(parameters);
    }

}
