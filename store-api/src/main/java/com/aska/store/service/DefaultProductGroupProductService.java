package com.aska.store.service;

import com.aska.store.entity.ProductGroupProductEntity;
import com.aska.store.mapper.ProductGroupProductMapper;
import com.aska.store.model.ProductGroupProductDTO;
import com.aska.store.repository.ProductGroupProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultProductGroupProductService implements ProductGroupProductService {

    @Autowired
    private ProductGroupProductRepository productGroupProductRepository;

    @Autowired
    private ProductGroupProductMapper productGroupProductMapper;

    @Override
    public List<ProductGroupProductDTO>  findByProductGroupId(long productGroupId) {
        final List<ProductGroupProductEntity> productGroupProductEntities =  productGroupProductRepository.findAllByProductGroupId(productGroupId);
        return productGroupProductEntities.stream().map(productGroupProductMapper::from).collect(Collectors.toList());
    }
}
