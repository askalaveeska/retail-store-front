package com.aska.store.service;

import com.aska.store.model.OrderDTO;

public interface OrderService {
    OrderDTO placeOrder(final OrderDTO orderDTO);
}
