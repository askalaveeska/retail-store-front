package com.aska.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Currency;
@Entity
@Table(name = "order_line")
public class OrderLineEntity {

    private Long orderLineId;
    private Long orderId;
    private Long productId;
    private String productName;
    private double price;
    private Long quantity;
    @OneToOne
    private OrderEntity order;

}
