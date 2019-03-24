package com.aska.admin.store.controller;

import com.aska.admin.store.entity.ProductGroupProductEntity;
import com.aska.admin.store.mapper.ProductGroupProductMapper;
import com.aska.admin.store.model.ProductGroupProductDTO;
import com.aska.admin.store.repository.ProductGroupProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.xml.ws.Response;
import java.util.Optional;

@RestController
public class ProductGroupProductController {

    @Autowired
   private ProductGroupProductRepository productGroupProductRepository;

    @Autowired
    private ProductGroupProductMapper productGroupProductMapper;

    @GetMapping("api/productGroupProduct/{productGroupProductId}")
    public ResponseEntity getProductGroupProducts(@PathVariable final long productGroupProductId){
        final Optional<ProductGroupProductEntity> productGroupProductEntity = productGroupProductRepository.findById(productGroupProductId);
        if(productGroupProductEntity.isPresent()){
            return ResponseEntity.ok(productGroupProductEntity.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("api/productGroupProduct")
    public ResponseEntity createProductGroupProduct(@RequestBody final ProductGroupProductDTO productGroupProductDTO){
        final ProductGroupProductEntity productGroupProductEntity = productGroupProductMapper.from(productGroupProductDTO);
        return ResponseEntity.ok(productGroupProductRepository.save(productGroupProductEntity));
    }

}
