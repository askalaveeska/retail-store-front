package com.aska.admin.store.service;

import com.aska.admin.store.entity.ProductEntity;
import com.aska.admin.store.entity.ProductGroupEntity;
import com.aska.admin.store.mapper.ProductGroupMapper;
import com.aska.admin.store.mapper.ProductMapper;
import com.aska.admin.store.model.ProductDTO;
import com.aska.admin.store.model.ProductGroupDTO;
import com.aska.admin.store.repository.ProductGroupRepository;
import com.aska.admin.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by askalaveeska on 27/02/19.
 */
@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductGroupMapper productGroupMapper;

    @Override
    public ProductDTO findByProductId(long productId) {
        final ProductEntity productEntity = productRepository.findByProductId(productId);
        return productMapper.from(productEntity);
    }

    @Override
    public List<ProductDTO> findAllByCategoryEntityCategoryId(long categoryId) {
        final List<ProductEntity> productEntities = productRepository.findAllByCategoryEntityCategoryId(categoryId);
        return productEntities.stream().map(productMapper::from).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByProductId(List<Long> productIds) {
        final List<ProductEntity> productEntities = productRepository.findAllByProductId(productIds);
        return productEntities.stream().map(productMapper::from).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByBrandEntityBrandId(long brandId) {
        final List<ProductEntity> productEntities = productRepository.findAllByBrandEntityBrandId(brandId);
        return productEntities.stream().map(productMapper::from).collect(Collectors.toList());
    }
}
