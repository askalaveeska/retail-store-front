package com.aska.store.service;

import com.aska.store.entity.ProductGroupEntity;
import com.aska.store.mapper.ProductGroupMapper;
import com.aska.store.model.ProductGroupDTO;
import com.aska.store.model.ProductGroupProductDTO;
import com.aska.store.repository.ProductGroupProductRepository;
import com.aska.store.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Service
public class DefaultProductGroupService implements ProductGroupService {

    @Autowired
    private ProductGroupMapper productGroupMapper;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductGroupProductRepository productGroupProductRepository;

    @Override
    public ProductGroupDTO findByStoreId(long storeId) {
        final ProductGroupEntity productGroupEntity =productGroupRepository.findByIsActiveTrueAndStoreEntityStoreId(storeId);
        return productGroupMapper.from(productGroupEntity);
    }

    @Override
    public ProductGroupDTO findByProductGroupId(long productGroupId) {
        final ProductGroupEntity productGroupEntity =productGroupRepository.findByProductGroupId(productGroupId);
        return productGroupMapper.from(productGroupEntity);
    }

    public List<Long> findProductGroupProducts(long productGroupId) {
        return productGroupProductRepository.findAllProductIdByProductGroupEntityProductGroupId(productGroupId);
    }
}
