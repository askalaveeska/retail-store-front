package com.aska.admin.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Entity
@Table(name = "order_status")
public class OrderStatusEntity {
    @Id
    @Column(name = "status_id")
    private Long  id;
    @Column(name = "status_description")
    private String statusDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
