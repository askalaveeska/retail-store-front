package com.aska.admin.store.controller;

import com.aska.admin.store.entity.ProductGroupEntity;
import com.aska.admin.store.mapper.ProductGroupMapper;
import com.aska.admin.store.model.ProductGroupDTO;
import com.aska.admin.store.repository.ProductGroupRepository;
import com.aska.admin.store.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductGroupController {

    @Autowired
    private ProductGroupMapper productGroupMapper;
    @Autowired
    private ProductGroupRepository productGroupRepository;

    @GetMapping("api/productGroup/{productGroupId}")
    public ResponseEntity getProductGroup(@PathVariable final long productGroupId){
        final Optional<ProductGroupEntity> productGroupEntity = productGroupRepository.findById(productGroupId);
        if (productGroupEntity.isPresent()){
            return ResponseEntity.ok(productGroupMapper.from(productGroupEntity.get()));
        }
        else {
            return  ResponseEntity.notFound().build();
        }
    }
    @PostMapping("api/productGroup")
    public ResponseEntity createProductGroup(@RequestBody final ProductGroupDTO productGroupDTO){
        if(productGroupRepository.existsByProductGroupName(productGroupDTO.getProductGroupName())){
            return ResponseEntity.badRequest().body(StoreUtil.getErrorObject("productGroupName","product group name already exists!"));
        }
        else{
            final ProductGroupEntity productGroupEntity = productGroupMapper.from(productGroupDTO);
            productGroupRepository.save(productGroupEntity);
            return ResponseEntity.accepted().build();
        }
    }

    @PutMapping
    public ResponseEntity updateProductGroup(@RequestBody final ProductGroupDTO productGroupDTO){
        final ProductGroupEntity productGroupEntity = productGroupMapper.from(productGroupDTO);
        productGroupRepository.save(productGroupEntity);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity deleteProductGroup(@PathVariable final long productGroupId){
        productGroupRepository.deleteById(productGroupId);
        return ResponseEntity.ok().build();
    }



}
