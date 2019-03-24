package com.aska.store.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreDTO {

    private Long storeId;
    private Long productGroupId;
    private String storeName;
    private String description;
    private String image;
    private List<ProductGroupDTO> productGroup;
    private List<AddressDTO> addressList;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Long productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ProductGroupDTO> getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(List<ProductGroupDTO> productGroup) {
        this.productGroup = productGroup;
    }

    public List<AddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDTO> addressList) {
        this.addressList = addressList;
    }
}
