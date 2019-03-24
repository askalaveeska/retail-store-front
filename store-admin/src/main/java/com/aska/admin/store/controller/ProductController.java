package com.aska.admin.store.controller;

import com.aska.admin.store.entity.ProductEntity;
import com.aska.admin.store.mapper.ProductMapper;
import com.aska.admin.store.model.ProductDTO;
import com.aska.admin.store.repository.ProductRepository;
import com.aska.admin.store.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    //should not be using this api
    @GetMapping("api/products")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        final List<ProductEntity> productEntities = productRepository.findAll();
        return ResponseEntity.ok(productEntities.stream().map(productMapper::from).collect(Collectors.toList()));
    }
    @GetMapping("api/products/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final long productId){
        final Optional<ProductEntity> productEntity = productRepository.findById(productId);
        if (productEntity.isPresent()){
            return ResponseEntity.ok(productMapper.from(productEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("api/products/")
    public ResponseEntity createProduct(@RequestBody final ProductDTO productDTO){
        final boolean exists = productRepository.existsByProductName(productDTO.getProductName());
        if (exists){
            ResponseEntity.badRequest().body(StoreUtil.getErrorObject("productName","store name already exists!"));
        }
        else {
            productRepository.save(productMapper.from(productDTO));
        }
        return ResponseEntity.ok().build();
    }
    @PutMapping("api/products/")
    public ResponseEntity updateProduct(@RequestBody final ProductDTO productDTO){
            productRepository.save(productMapper.from(productDTO));
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("api/products/{productId}")
    public ResponseEntity removeProduct(@RequestBody final long productId){
        productRepository.deleteById(productId);
        return ResponseEntity.ok().build();
    }

}
