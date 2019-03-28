package com.aska.store.service;

import com.aska.store.common.Constants;
import com.aska.store.entity.OrderEntity;
import com.aska.store.mapper.OrderMapper;
import com.aska.store.model.OrderDTO;
import com.aska.store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DefaultOrderService implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        orderDTO.setOrderStatus(Constants.ORDER_PLACED);
        orderDTO.setOrderDate(new Date());
        final OrderEntity orderEntity = orderMapper.from(orderDTO);
        final OrderEntity placedOrderEntity = orderRepository.save(orderEntity);

        return orderMapper.from(placedOrderEntity);
    }
}
