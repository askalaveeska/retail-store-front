package com.aska.admin.store.controller;

import com.aska.admin.store.model.Product;
import com.aska.admin.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by askalaveeska on 26/02/19.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        //gets all the products
        return null;
    }
}
