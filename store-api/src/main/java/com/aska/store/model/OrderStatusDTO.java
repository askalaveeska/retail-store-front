package com.aska.store.model;

import org.springframework.stereotype.Component;

@Component
public class OrderStatusDTO {

    private Long  statusId;
    private String statusDescription;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
