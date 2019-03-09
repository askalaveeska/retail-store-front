package com.aska.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class ProductGroupEntity {

    private Long productGroupId;
    private Long storeId;
    private String productGroupName;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product_group", fetch = FetchType.EAGER)
    @JoinColumn(name = "productGroupId")
    private List<ProductEntity> products;

}
