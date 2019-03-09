package com.aska.store.service;

import com.aska.store.entity.ProductEntity;
import com.aska.store.mapper.ProductMapper;
import com.aska.store.model.ProductDTO;
import com.aska.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by askalaveeska on 27/02/19.
 */
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO findByProductIdIsActive(long productId) {
        final ProductEntity productEntity = productRepository.findByProductIdIsActive(productId);
        return productMapper.from(productEntity);
    }

    @Override
    public List<ProductDTO> findByProductGroupIdAndStoreId(long productGroupId, long storeId) {
        final List<ProductEntity> productEntities = productRepository.findByProductGroupIdAndStoreId(productGroupId,storeId);
        return productEntities.stream().map(productMapper::from).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByCategoryId(long categoryId) {
        final List<ProductEntity> productEntities = productRepository.findByCategoryId(categoryId);
        return productEntities.stream().map(productMapper::from).collect(Collectors.toList());
    }
}
