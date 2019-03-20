package com.aska.admin.store.service;

import com.aska.store.entity.ProductGroupEntity;
import com.aska.store.mapper.ProductGroupMapper;
import com.aska.store.model.ProductGroupDTO;
import com.aska.store.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Service
public class DefaultProductGroupService implements ProductGroupService {

    @Autowired
    private ProductGroupMapper productGroupMapper;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Override
    public ProductGroupDTO findByStoreId(long store) {
        final ProductGroupEntity productGroupEntity =productGroupRepository.findByStoreEntityStoreId(store);
        return productGroupMapper.from(productGroupEntity);
    }

    @Override
    public ProductGroupDTO findByProductGroupId(long productGroupId) {
        final ProductGroupEntity productGroupEntity =productGroupRepository.findByProductGroupId(productGroupId);
        return productGroupMapper.from(productGroupEntity);
    }
}
