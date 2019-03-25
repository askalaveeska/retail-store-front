package com.aska.store.mapper;

import com.aska.store.entity.OrderEntity;
import com.aska.store.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {
    @Autowired
    private OrderLineMapper orderLineMapper;

    public OrderDTO from(final OrderEntity orderEntity){
        final OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderEntity.getOrderId());
        orderDTO.setOrderDate(orderEntity.getOrderDate());
        orderDTO.setLastUpdatedDate(orderEntity.getLastUpdatedDate());
        orderDTO.setOrderEmail(orderEntity.getOrderEmail());
        orderDTO.setOrderStatus(orderEntity.getOrderStatus());

        //loading order address
        orderDTO.setAddressLine1(orderEntity.getAddressLine1());
        orderDTO.setAddressLine2(orderEntity.getAddressLine2());
        orderDTO.setAddressLine3(orderEntity.getAddressLine3());
        orderDTO.setCity(orderEntity.getCity());
        orderDTO.setState(orderEntity.getState());
        orderDTO.setPhoneNumber(orderEntity.getPhoneNumber());
        orderDTO.setPinCode(orderEntity.getPinCode());
        orderDTO.setCountry(orderEntity.getCountry());

        orderDTO.setOrderTotal(orderEntity.getOrderTotal());
        orderDTO.setOrderLines(orderEntity.getOrderLines().stream().map(orderLineMapper::from).collect(Collectors.toList()));
        return orderDTO;
    }

    public OrderEntity from(final OrderDTO orderDTO){
        final OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderDTO.getOrderId());
        orderEntity.setOrderDate(orderDTO.getOrderDate());
        orderEntity.setLastUpdatedDate(orderDTO.getLastUpdatedDate());
        orderEntity.setOrderEmail(orderDTO.getOrderEmail());
        orderEntity.setOrderStatus(orderDTO.getOrderStatus());
        //loading order address
        orderEntity.setAddressLine1(orderDTO.getAddressLine1());
        orderEntity.setAddressLine2(orderDTO.getAddressLine2());
        orderEntity.setAddressLine3(orderDTO.getAddressLine3());
        orderEntity.setCity(orderDTO.getCity());
        orderEntity.setState(orderDTO.getState());
        orderEntity.setPhoneNumber(orderDTO.getPhoneNumber());
        orderEntity.setPinCode(orderDTO.getPinCode());
        orderEntity.setCountry(orderDTO.getCountry());

        orderEntity.setOrderTotal(orderDTO.getOrderTotal());
        orderEntity.setOrderLines(orderDTO.getOrderLines().stream().map(orderLineMapper::from).collect(Collectors.toList()));
        return orderEntity;
    }
}
