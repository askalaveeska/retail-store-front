package com.aska.store.mapper;

import com.aska.store.entity.ProductEntity;
import com.aska.store.model.ProductDTO;

/**
 * Created by ppalpandi on 3/9/2019.
 */
public class ProductMapper {

    public ProductDTO from(final ProductEntity productEntity){
        final ProductDTO productDTO = new ProductDTO();
        productDTO.setActive(productEntity.isActive());
        productDTO.setCatagoryId(productEntity.getCatagoryId());
        productDTO.setCatagoryName(productEntity.getCatagoryName());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setProductGroupId(productEntity.getProductGroupId());
        productDTO.setDiscountPrice(productEntity.getDiscountPrice());
        productDTO.setMaxRetailPrice(productEntity.getMaxRetailPrice());
        productDTO.setQuantity(productEntity.getQuantity());
        productDTO.setSupplierPrice(productEntity.getSupplierPrice());
        return productDTO;
    }
}
