package com.aska.admin.store.model;

import org.springframework.stereotype.Component;

@Component
public class ProductGroupProductDTO {

    private Long  productGroupProductId;
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
}
