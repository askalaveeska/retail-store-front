package com.aska.store.repository;

import com.aska.store.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends CrudRepository<OrderEntity, Long> {
}
