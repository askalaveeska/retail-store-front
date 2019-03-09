package com.aska.store.controller;

import com.aska.store.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by askalaveeska on 26/02/19.
 */
@RestController
public class ProductController {

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        //gets all the products
        return null;
    }
}
