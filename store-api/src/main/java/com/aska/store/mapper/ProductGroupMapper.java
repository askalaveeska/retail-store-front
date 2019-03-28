package com.aska.store.mapper;

import com.aska.store.entity.ProductGroupEntity;
import com.aska.store.model.ProductGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Component
public class ProductGroupMapper {

    public ProductGroupDTO from (final ProductGroupEntity productGroupEntity){
        final ProductGroupDTO productGroupDTO = new ProductGroupDTO();
        productGroupDTO.setProductGroupId(productGroupEntity.getProductGroupId());
        productGroupDTO.setStoreId(productGroupEntity.getStoreId());
        productGroupDTO.setActive(productGroupEntity.isActive());
        productGroupDTO.setProductGroupName(productGroupEntity.getProductGroupName());
        return productGroupDTO;
    }

    public ProductGroupEntity from (final ProductGroupDTO productGroupDTO){
        final ProductGroupEntity productGroupEntity = new ProductGroupEntity();
        productGroupEntity.setActive(productGroupDTO.isActive());
        productGroupEntity.setProductGroupId(productGroupDTO.getProductGroupId());
        productGroupEntity.setStoreId(productGroupDTO.getStoreId());
        productGroupEntity.setProductGroupName(productGroupDTO.getProductGroupName());
        return productGroupEntity;
    }

}
