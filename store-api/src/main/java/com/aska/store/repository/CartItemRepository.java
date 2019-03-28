package com.aska.store.repository;

import com.aska.store.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository  extends CrudRepository<CartItemEntity,Long> {
    CartItemEntity findByProductId(final long productId);
    List<CartItemEntity> findAllByCartId(final long cartId);
    void deleteByShoppingCartCartId(final long cartId);

}
