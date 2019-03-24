package com.aska.admin.store.mapper;

import com.aska.admin.store.entity.ProductGroupProductEntity;
import com.aska.admin.store.model.ProductGroupProductDTO;

public class ProductGroupProductMapper {

    public ProductGroupProductDTO from(final ProductGroupProductEntity productGroupProductEntity){
        final ProductGroupProductDTO productGroupProductDTO = new ProductGroupProductDTO();
        productGroupProductDTO.setProductGroupProductId(productGroupProductEntity.getProductGroupProductId());
        productGroupProductDTO.setProductId(productGroupProductEntity.getProductId());
        return productGroupProductDTO;
    }

    public ProductGroupProductEntity from(final ProductGroupProductDTO productGroupProductDTO){
        final ProductGroupProductEntity productGroupProductEntity = new ProductGroupProductEntity();
        productGroupProductEntity.setProductGroupProductId(productGroupProductDTO.getProductGroupProductId());
        productGroupProductEntity.setProductId(productGroupProductDTO.getProductId());
        return productGroupProductEntity;
    }

}
