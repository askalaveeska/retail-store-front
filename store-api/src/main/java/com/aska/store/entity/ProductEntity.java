package com.aska.store.entity;

import java.util.Currency;

/**
 * Created by askalaveeska on 26/02/19.
 */
public class ProductEntity {

    private long id;
    private String name;
    private String description;
    private int quantity;
    private Currency supplierPrice;
    private Currency maxRetailPrice;
    private Currency discountPrice;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Currency getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(Currency supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public Currency getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(Currency maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public Currency getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Currency discountPrice) {
        this.discountPrice = discountPrice;
    }
}
