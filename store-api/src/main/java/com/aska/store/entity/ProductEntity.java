package com.aska.store.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Currency;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Entity
@Table(name = "product")
public class ProductEntity {

    private long productId;
    private long productGroupId;
    private long catagoryId;
    private long catagoryName;
    private boolean isActive;
    private String productName;
    private String description;
    private int quantity;
    private double supplierPrice;
    private double maxRetailPrice;
    private double discountPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public long getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(long catagoryName) {
        this.catagoryName = catagoryName;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(double maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(long productGroupId) {
        this.productGroupId = productGroupId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
