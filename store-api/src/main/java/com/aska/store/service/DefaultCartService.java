package com.aska.store.service;

import com.aska.store.entity.CartItemEntity;
import com.aska.store.entity.ShoppingCartEntity;
import com.aska.store.mapper.ShoppingCartItemMapper;
import com.aska.store.mapper.ShoppingCartMapper;
import com.aska.store.model.ProductDTO;
import com.aska.store.model.ShoppingCartDTO;
import com.aska.store.model.ShoppingCartItemDTO;
import com.aska.store.model.UserDTO;
import com.aska.store.repository.CartItemRepository;
import com.aska.store.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class DefaultCartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;

    public ShoppingCartDTO addToCart(final UserDTO userDTO, final ShoppingCartItemDTO shoppingCartItemDTO, final ShoppingCartDTO sessionCart){
        final ShoppingCartEntity shoppingCartEntity;
        if (Objects.nonNull(sessionCart)){
            shoppingCartEntity = shoppingCartMapper.from(sessionCart);
        }
        else{
            shoppingCartEntity = cartRepository.findByUserUserId(userDTO.getUserId());
        }
        if (Objects.nonNull(shoppingCartEntity)){
            final CartItemEntity cartItemEntity =  cartItemRepository.findByProductId(shoppingCartItemDTO.getProductId());
            if (Objects.nonNull(cartItemEntity)){
                //can check max allowed quantity
                final ShoppingCartEntity cartEntity = cartItemEntity.getShoppingCart();
                final double cartTotal = cartEntity.getCartTotal() + shoppingCartItemDTO.getLineItemTotal();
                cartEntity.setCartTotal(cartTotal);
                cartItemEntity.setShoppingCart(cartEntity);
                final long quantity = cartItemEntity.getQuantity()+shoppingCartItemDTO.getQuantity();
                cartItemEntity.setQuantity(quantity);
                cartItemRepository.save(cartItemEntity);
                return shoppingCartMapper.from(cartEntity);
            }
            else {
                final CartItemEntity cartItem = shoppingCartItemMapper.from(shoppingCartItemDTO);
                shoppingCartEntity.setCartTotal(shoppingCartEntity.getCartTotal() + shoppingCartItemDTO.getLineItemTotal());
                cartItemRepository.save(cartItem);
                return shoppingCartMapper.from(shoppingCartEntity);
            }
        }

        else {
            final ShoppingCartDTO shoppingCartDTO =  createCart(shoppingCartItemDTO);
            cartRepository.save(shoppingCartMapper.from(shoppingCartDTO));
            return shoppingCartDTO;
        }

    }

    private ShoppingCartDTO createCart(final ShoppingCartItemDTO shoppingCartItemDTO){
        final ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setDiscountAmount(0);
        shoppingCartDTO.setCartTotal(shoppingCartItemDTO.getLineItemTotal());
        List<ShoppingCartItemDTO> cartItems  =  new ArrayList<>();
        cartItems.add(shoppingCartItemDTO);
        shoppingCartDTO.setCartItems(cartItems);
        return shoppingCartDTO;
    }

    public  ShoppingCartDTO removeItemFromCart(final ShoppingCartDTO sessionCart, final Long cartItemId){
            List<ShoppingCartItemDTO> shoppingCartItems =  sessionCart.getCartItems();
            Optional<ShoppingCartItemDTO> shoppingCartItemDTO = shoppingCartItems.stream().filter(sci->sci.getItemId() == cartItemId).findFirst();
            sessionCart.setCartTotal(sessionCart.getCartTotal()-shoppingCartItemDTO.get().getLineItemTotal());
            shoppingCartItems.removeIf(sci->sci.getItemId() == cartItemId);
            sessionCart.setCartItems(shoppingCartItems);
            cartRepository.save(shoppingCartMapper.from(sessionCart));
            return sessionCart;
    }

}
