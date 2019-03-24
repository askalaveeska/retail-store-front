package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.entity.ProductGroupEntity;
import com.aska.store.mapper.ProductGroupMapper;
import com.aska.store.model.ProductGroupDTO;
import com.aska.store.repository.ProductGroupRepository;
import com.aska.store.service.ProductGroupService;
import com.aska.store.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Controller
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
