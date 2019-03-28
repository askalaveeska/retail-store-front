package com.aska.store.model;

import org.springframework.stereotype.Component;

@Component
public class ProductGroupProductDTO {

    private Long  productGroupProductId;
    private Long  productGroupId;
    private Long productId;

    public Long getProductGroupProductId() {
        return productGroupProductId;
    }

    public void setProductGroupProductId(Long productGroupProductId) {
        this.productGroupProductId = productGroupProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Long productGroupId) {
        this.productGroupId = productGroupId;
    }
}
