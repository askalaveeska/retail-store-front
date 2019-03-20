package com.aska.admin.store.mapper;

import com.aska.admin.store.entity.ProductGroupEntity;
import com.aska.admin.store.model.ProductGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Component
public class ProductGroupMapper {

    @Autowired
    ProductMapper productMapper;

    public ProductGroupDTO from (final ProductGroupEntity productGroupEntity){
        final ProductGroupDTO productGroupDTO = new ProductGroupDTO();
        productGroupDTO.setActive(productGroupEntity.isActive());
        productGroupDTO.setProductGroupId(productGroupEntity.getProductGroupId());
        productGroupDTO.setProductGroupName(productGroupEntity.getProductGroupName());
        productGroupDTO.setProducts(productGroupEntity.getProducts());
        //productGroupDTO.setStoreId(productGroupEntity.getStoreId());
        return productGroupDTO;
    }

}
