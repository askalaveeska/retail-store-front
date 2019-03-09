package com.aska.store.entity;

import java.util.Date;
import java.util.Set;

public class OrderEntity {

    private long orderId;
    private Date orderDate;
    private Date lastUpdateddate;
    private String email;
    private Set<OrderLineEntity> orderLines;

}
