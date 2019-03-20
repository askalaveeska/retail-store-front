package com.aska.admin.store.model;

import com.aska.admin.store.entity.ProductGroupProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Component
public class ProductGroupDTO {

    private Long productGroupId;
    private Long storeId;
    private String productGroupName;
    private boolean isActive;
    private List<ProductGroupProductEntity> products;

    public Long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Long productGroupId) {
        this.productGroupId = productGroupId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<ProductGroupProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductGroupProductEntity> products) {
        this.products = products;
    }
}
