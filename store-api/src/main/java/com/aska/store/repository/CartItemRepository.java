package com.aska.store.repository;

import com.aska.store.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository  extends CrudRepository<CartItemEntity,Long> {
    CartItemEntity findByProductId(final long productId);
    void deleteByShoppingCartCartId(final long cartId);

}
