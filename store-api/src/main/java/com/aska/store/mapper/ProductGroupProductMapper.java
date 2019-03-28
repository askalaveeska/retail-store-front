package com.aska.store.mapper;

import com.aska.store.entity.ProductGroupProductEntity;
import com.aska.store.model.ProductGroupProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductGroupProductMapper {

    public ProductGroupProductDTO from(final ProductGroupProductEntity productGroupProductEntity){
        final ProductGroupProductDTO productGroupProductDTO = new ProductGroupProductDTO();
        productGroupProductDTO.setProductGroupProductId(productGroupProductEntity.getProductGroupProductId());
        productGroupProductDTO.setProductGroupId(productGroupProductEntity.getProductGroupId());
        productGroupProductDTO.setProductId(productGroupProductEntity.getProductId());
        return productGroupProductDTO;
    }

    public ProductGroupProductEntity from(final ProductGroupProductDTO productGroupProductDTO){
        final ProductGroupProductEntity productGroupProductEntity = new ProductGroupProductEntity();
        productGroupProductEntity.setProductGroupProductId(productGroupProductDTO.getProductGroupProductId());
        productGroupProductEntity.setProductGroupId(productGroupProductDTO.getProductGroupId());
        productGroupProductEntity.setProductId(productGroupProductDTO.getProductId());
        return productGroupProductEntity;
    }

}
