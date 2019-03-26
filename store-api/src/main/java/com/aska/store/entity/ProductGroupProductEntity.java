package com.aska.store.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_group_product")
public class ProductGroupProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_group_product_id")
    private Long  productGroupProductId;
    @Column(name = "product_id")
    private Long productId;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_group_id")
    private ProductGroupEntity productGroupEntity;

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

    public ProductGroupEntity getProductGroupEntity() {
        return productGroupEntity;
    }

    public void setProductGroupEntity(ProductGroupEntity productGroupEntity) {
        this.productGroupEntity = productGroupEntity;
    }
}








