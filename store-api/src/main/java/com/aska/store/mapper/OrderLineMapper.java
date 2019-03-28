package com.aska.store.mapper;

import com.aska.store.entity.OrderLineEntity;
import com.aska.store.model.OrderLineDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {

    public OrderLineDTO from(final OrderLineEntity orderLineEntity){
        final OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setOrderLineId(orderLineEntity.getOrderLineId());
        orderLineDTO.setOrderId(orderLineEntity.getOrderId());
        orderLineDTO.setPrice(orderLineEntity.getPrice());
        orderLineDTO.setProductId(orderLineEntity.getProductId());
        orderLineDTO.setProductName(orderLineEntity.getProductName());
        orderLineDTO.setQuantity(orderLineEntity.getQuantity());
        return orderLineDTO;
    }

    public OrderLineEntity from(final OrderLineDTO orderLineDTO){
        final OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrderLineId(orderLineDTO.getOrderLineId());
        orderLineDTO.setOrderId(orderLineEntity.getOrderId());
        orderLineEntity.setPrice(orderLineDTO.getPrice());
        orderLineEntity.setProductId(orderLineDTO.getProductId());
        orderLineEntity.setProductName(orderLineDTO.getProductName());
        orderLineEntity.setQuantity(orderLineDTO.getQuantity());
        return orderLineEntity;
    }

}
