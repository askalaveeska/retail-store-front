package com.aska.store.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "product_group_id")
    private Long productGroupId;
    @Column(name = "store_name")
    private String storeName;
    @Column(name = "store_description")
    private String description;
    @Column(name = "store_image")
    private String image;
    @OneToMany
    @JoinColumn(name = "product_group_id")
    private List<ProductGroupEntity> productGroup;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserEntity> users;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public List<ProductGroupEntity> getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(List<ProductGroupEntity> productGroup) {
        this.productGroup = productGroup;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public Long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Long productGroupId) {
        this.productGroupId = productGroupId;
    }
}
