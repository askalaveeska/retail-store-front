package com.aska.store.entity;

import javax.persistence.OneToMany;
import java.util.Set;

public class StoreEntity {

    private Long id;
    private String storeName;
    private String description;
    private String image;
    private Set<ProductGroupEntity> productGroup;
    @OneToMany
    private Set<UserEntity> users;

}
