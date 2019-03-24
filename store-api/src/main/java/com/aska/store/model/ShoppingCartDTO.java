package com.aska.store.model;


import com.aska.store.entity.CartItemEntity;

import java.util.List;

public class ShoppingCartDTO {

    private Long cartId;
    private double cartTotal;
    private double discountAmount;
    private List<ShoppingCartItemDTO> cartItems;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public List<ShoppingCartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }
}
