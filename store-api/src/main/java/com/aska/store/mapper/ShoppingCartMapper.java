package com.aska.store.mapper;

import com.aska.store.entity.ShoppingCartEntity;
import com.aska.store.model.ShoppingCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {

    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;

    @Autowired
    private UserMapper userMapper;


    public ShoppingCartDTO from(final ShoppingCartEntity shoppingCartEntity){
        final ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setCartId(shoppingCartEntity.getCartId());
        shoppingCartDTO.setCartTotal(shoppingCartEntity.getCartTotal());
        shoppingCartDTO.setDiscountAmount(shoppingCartEntity.getDiscountAmount());
        shoppingCartDTO.setCartId(shoppingCartEntity.getCartId());

        shoppingCartDTO.setCartItems(shoppingCartEntity.getCartItems().stream().map(shoppingCartItemMapper::from).collect(Collectors.toList()));


        shoppingCartDTO.setUserDTO(userMapper.from(shoppingCartEntity.getUser()));

        return shoppingCartDTO;
    }

    public ShoppingCartEntity from(final ShoppingCartDTO shoppingCartDTO){

        final ShoppingCartEntity  shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setCartId(shoppingCartDTO.getCartId());
        shoppingCartEntity.setCartTotal(shoppingCartDTO.getCartTotal());
        shoppingCartEntity.setDiscountAmount(shoppingCartDTO.getDiscountAmount());
        shoppingCartEntity.setCartId(shoppingCartDTO.getCartId());
        shoppingCartEntity.setCartItems(shoppingCartDTO.getCartItems().stream().map(shoppingCartItemMapper::from).collect(Collectors.toList()));

        shoppingCartEntity.setUser(userMapper.from(shoppingCartDTO.getUserDTO()));
        return shoppingCartEntity;
    }

}
