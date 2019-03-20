package com.aska.store.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_group_product")
public class ProductGroupProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_group_product_id")
    private Long  productGroupProductId;
    @Column(name = "product_id")
    private Long productId;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_group_id")
    private ProductGroupEntity productGroupEntity;


}








