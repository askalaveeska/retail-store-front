package com.aska.store.mapper;

import com.aska.store.entity.ProductEntity;
import com.aska.store.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Component
public class ProductMapper {

    public ProductDTO from(final ProductEntity productEntity){

        final ProductDTO productDTO = new ProductDTO();
        productDTO.setActive(productEntity.isActive());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setCategoryId(productEntity.getCategoryId());
        productDTO.setBrandId(productEntity.getBrandId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setDiscountPrice(productEntity.getDiscountPrice());
        productDTO.setMaxRetailPrice(productEntity.getMaxRetailPrice());
        productDTO.setQuantity(productEntity.getQuantity());
        productDTO.setSupplierPrice(productEntity.getSupplierPrice());

        return productDTO;
    }

    public ProductEntity from(final ProductDTO productDTO){
        final ProductEntity productEntity  = new ProductEntity();
        productEntity.setActive(productDTO.isActive());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setProductId(productDTO.getProductId());
        productEntity.setCategoryId(productDTO.getCategoryId());
        productEntity.setBrandId(productEntity.getBrandId());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setDiscountPrice(productDTO.getDiscountPrice());
        productEntity.setMaxRetailPrice(productDTO.getMaxRetailPrice());
        productEntity.setQuantity(productDTO.getQuantity());
        productEntity.setSupplierPrice(productDTO.getSupplierPrice());
        return productEntity;
    }
}
