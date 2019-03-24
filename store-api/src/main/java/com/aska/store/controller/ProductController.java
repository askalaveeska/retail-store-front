package com.aska.store.controller;

import com.aska.store.common.RedirectPages;
import com.aska.store.entity.ProductEntity;
import com.aska.store.mapper.ProductMapper;
import com.aska.store.model.ProductDTO;
import com.aska.store.repository.ProductRepository;
import com.aska.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("api/products/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final long productId){
        final Optional<ProductEntity> productEntity = productRepository.findById(productId);
        if (productEntity.isPresent()){
            return ResponseEntity.ok(productMapper.from(productEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
