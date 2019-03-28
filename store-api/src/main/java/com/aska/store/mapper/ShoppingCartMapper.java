package com.aska.store.mapper;

import com.aska.store.entity.ShoppingCartEntity;
import com.aska.store.model.ShoppingCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {

    public ShoppingCartDTO from(final ShoppingCartEntity shoppingCartEntity){
        final ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setCartId(shoppingCartEntity.getCartId());
        shoppingCartDTO.setUserId(shoppingCartEntity.getUserId());
        shoppingCartDTO.setCartTotal(shoppingCartEntity.getCartTotal());
        shoppingCartDTO.setDiscountAmount(shoppingCartEntity.getDiscountAmount());
        shoppingCartDTO.setUserId(shoppingCartEntity.getUserId());

        return shoppingCartDTO;
    }

    public ShoppingCartEntity from(final ShoppingCartDTO shoppingCartDTO){

        final ShoppingCartEntity  shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setCartId(shoppingCartDTO.getCartId());
        shoppingCartEntity.setCartTotal(shoppingCartDTO.getCartTotal());
        shoppingCartEntity.setDiscountAmount(shoppingCartDTO.getDiscountAmount());
        shoppingCartEntity.setUserId(shoppingCartDTO.getUserId());

        return shoppingCartEntity;
    }

}
