package com.aska.store.service;

import com.aska.store.entity.CategoryEntity;
import com.aska.store.entity.ProductEntity;
import com.aska.store.entity.ProductGroupEntity;
import com.aska.store.entity.ProductGroupProductEntity;
import com.aska.store.mapper.CategoryMapper;
import com.aska.store.mapper.ProductMapper;
import com.aska.store.model.CategoryDTO;
import com.aska.store.model.ProductDTO;
import com.aska.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by askalaveeska on 27/02/19.
 */
@Service
public class DefaultProductService implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductGroupProductRepository productGroupProductRepository;

    @Autowired
    private ProductGroupService productGroupService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ProductDTO findByProductIdIsActive(long productId) {
        final ProductEntity productEntity = productRepository.findByProductIdAndIsActiveTrue(productId);
        return productMapper.from(productEntity);
    }

    @Override
    public List<ProductDTO> findByCategoryId(long categoryId) {
//        final List<ProductEntity> productEntities = productRepository.findAllByCategoryEntityCategoryId(categoryId);
//        return productEntities.stream().map(productMapper::from).collect(Collectors.toList());
        return null;
    }

    @Override
    public ProductDTO findByProductIdAndIsActiveTrue(long productId) {
        return productMapper.from(productRepository.findByProductIdAndIsActiveTrue(productId));
    }

    @Override
    public ProductDTO findByProductId(long productId) {
        return productMapper.from(productRepository.findByProductId(productId));
    }

    @Override
    public List<ProductDTO> findAllByCategoryId(long categoryId, Pageable pageable) {
        return productRepository.findAllByCategoryId(categoryId,pageable).stream().map(productMapper::from).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByProductId(List<Long> productId, final Pageable pageable) {
        return productRepository.findAllByProductId(productId, pageable).stream().map(productMapper::from).collect(Collectors.toList()) ;
    }

    @Override
    public List<ProductDTO> findAllByBrandEntityId(final long brandId) {
        return productRepository.findAllByBrandEntityId(brandId).stream().map(productMapper::from).collect(Collectors.toList()) ;
    }

    @Override
    public boolean existsByProductName(final String productName) {
        return productRepository.existsByProductName(productName);
    }

    public List<Long> getAllProductIdsByProductGroupId(final long productGroupId) {

        final List<ProductGroupProductEntity> productGroupProductEntity =  productGroupProductRepository.findAllByProductGroupId(productGroupId);
        return productGroupProductEntity.stream().map(pgp->
            pgp.getProductGroupProductId()
        ).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getDistinctCategoriesByProductIds(List<Long> productIds) {
        final List<CategoryEntity> categoryEntities = categoryRepository.findDistinctByProductsProductIdIn(productIds);
        return categoryEntities.stream().map(categoryMapper::from).collect(Collectors.toList());
    }
}
