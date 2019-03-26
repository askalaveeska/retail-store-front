package com.aska.store.model;

public class ShoppingCartItemDTO {

    private Long itemId;
    private Long productId;
    private String ProductName;
    private int quantity;
    private double lineItemPrice;
    private double lineItemDiscount;
    private double LineItemTotal;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLineItemPrice() {
        return lineItemPrice;
    }

    public void setLineItemPrice(double lineItemPrice) {
        this.lineItemPrice = lineItemPrice;
    }

    public double getLineItemDiscount() {
        return lineItemDiscount;
    }

    public void setLineItemDiscount(double lineItemDiscount) {
        this.lineItemDiscount = lineItemDiscount;
    }

    public double getLineItemTotal() {
        return LineItemTotal;
    }

    public void setLineItemTotal(double lineItemTotal) {
        LineItemTotal = lineItemTotal;
    }
}
