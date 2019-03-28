package com.aska.store.mapper;

import com.aska.store.entity.CartItemEntity;
import com.aska.store.model.ShoppingCartItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartItemMapper {

    public ShoppingCartItemDTO from(final CartItemEntity cartItemEntity){
        final ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
        shoppingCartItemDTO.setItemId(cartItemEntity.getItemId());
        shoppingCartItemDTO.setCartId(cartItemEntity.getCartId());
        shoppingCartItemDTO.setLineItemDiscount(cartItemEntity.getItemDiscount());
        shoppingCartItemDTO.setLineItemPrice(cartItemEntity.getItemPrice());
        shoppingCartItemDTO.setLineItemTotal(cartItemEntity.getItemTotalPrice());
        shoppingCartItemDTO.setProductId(cartItemEntity.getProductId());
        shoppingCartItemDTO.setProductName(cartItemEntity.getProductName());
        shoppingCartItemDTO.setQuantity(cartItemEntity.getQuantity());
        return shoppingCartItemDTO;
    }

    public CartItemEntity from(final ShoppingCartItemDTO shoppingCartItemDTO){
        final CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setItemId(shoppingCartItemDTO.getItemId());
        cartItemEntity.setCartId(shoppingCartItemDTO.getCartId());
        cartItemEntity.setItemDiscount(shoppingCartItemDTO.getLineItemDiscount());
        cartItemEntity.setItemPrice(shoppingCartItemDTO.getLineItemPrice());
        cartItemEntity.setItemTotalPrice(shoppingCartItemDTO.getLineItemTotal());
        cartItemEntity.setProductId(shoppingCartItemDTO.getProductId());
        cartItemEntity.setProductName(shoppingCartItemDTO.getProductName());
        cartItemEntity.setQuantity(shoppingCartItemDTO.getQuantity());
        return cartItemEntity;
    }

}
