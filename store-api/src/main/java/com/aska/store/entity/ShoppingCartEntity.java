package com.aska.store.entity;

import javax.persistence.*;
import java.util.Currency;
import java.util.List;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

    private Long cartId;
    private double cartTotal;
    private double discountAmout;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopping_cart", fetch = FetchType.EAGER)
    private List<CartItemEntity> cartItems;
    private String emailId;


}
