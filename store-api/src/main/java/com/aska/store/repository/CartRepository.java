package com.aska.store.repository;

import com.aska.store.entity.ShoppingCartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends CrudRepository<ShoppingCartEntity,Long> {
    ShoppingCartEntity findByUserUserId(final long userId);
}
