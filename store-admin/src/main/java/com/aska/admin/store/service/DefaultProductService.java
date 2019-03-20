package com.aska.admin.store.service;

import com.aska.admin.store.entity.ProductEntity;
import com.aska.admin.store.mapper.ProductMapper;
import com.aska.admin.store.model.ProductDTO;
import com.aska.admin.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by askalaveeska on 27/02/19.
 */
@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO findByProductIdIsActive(long productId) {
        final ProductEntity productEntity = productRepository.findByProductIdAndIsActiveTrue(productId);
        return productMapper.from(productEntity);
    }

    @Override
    public List<ProductDTO> findByCategoryId(long categoryId) {
        final List<ProductEntity> productEntities = productRepository.findByCategoryEntityCategoryId(categoryId);
        return productEntities.stream().map(productMapper::from).collect(Collectors.toList());
    }

}
