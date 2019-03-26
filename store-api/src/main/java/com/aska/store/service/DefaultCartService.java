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

    public ShoppingCartDTO getCart(final UserDTO sessionUser, final ShoppingCartDTO sessionCart){
        if (Objects.nonNull(sessionCart)){
            return sessionCart;
        }
        final ShoppingCartEntity shoppingCartEntity = cartRepository.findByUserUserId(sessionUser.getUserId());
        return shoppingCartMapper.from(shoppingCartEntity);
    }

    public ShoppingCartDTO addToCart(final UserDTO userDTO, final ProductDTO productDTO, final ShoppingCartDTO sessionCart){
        final ShoppingCartEntity shoppingCartEntity;
        if (Objects.nonNull(sessionCart)){
            shoppingCartEntity = shoppingCartMapper.from(sessionCart);
        }
        else{
            shoppingCartEntity = cartRepository.findByUserUserId(userDTO.getUserId());
        }
        if (Objects.nonNull(shoppingCartEntity)){
            final CartItemEntity cartItemEntity =  cartItemRepository.findByProductId(productDTO.getProductId());
            if (Objects.nonNull(cartItemEntity)){
                //can check max allowed quantity
                final ShoppingCartEntity cartEntity = cartItemEntity.getShoppingCart();

                final double cartTotal = cartEntity.getCartTotal() + productDTO.getSupplierPrice();

                //need to calculate discount amount here
                cartEntity.setCartTotal(cartTotal);

                cartItemEntity.setShoppingCart(cartEntity);

                final int quantity = cartItemEntity.getQuantity()+productDTO.getQuantity();
                cartItemEntity.setQuantity(quantity);
                cartItemEntity.setItemTotalPrice(cartItemEntity.getItemTotalPrice()+productDTO.getSupplierPrice());
                cartItemRepository.save(cartItemEntity);
                return shoppingCartMapper.from(cartEntity);
            }
            else {
                final CartItemEntity cartItem = shoppingCartItemMapper.from(getLineItem(productDTO));
                //needs discount calculation here
                shoppingCartEntity.setCartTotal(shoppingCartEntity.getCartTotal() + cartItem.getItemTotalPrice());

                cartItemRepository.save(cartItem);
                return shoppingCartMapper.from(shoppingCartEntity);
            }
        }

        else {
            final ShoppingCartDTO shoppingCartDTO =  createNewCart(productDTO);
            cartRepository.save(shoppingCartMapper.from(shoppingCartDTO));
            return shoppingCartDTO;
        }

    }

    private ShoppingCartItemDTO getLineItem(final ProductDTO productDTO){
        final ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
        shoppingCartItemDTO.setProductName(productDTO.getProductName());
        shoppingCartItemDTO.setQuantity(productDTO.getQuantity());
        shoppingCartItemDTO.setLineItemPrice(productDTO.getSupplierPrice());
        shoppingCartItemDTO.setLineItemDiscount(0);
        final double lineItemTotal = productDTO.getQuantity() * productDTO.getSupplierPrice();
        shoppingCartItemDTO.setLineItemTotal(lineItemTotal);
        return shoppingCartItemDTO;
    }
    private ShoppingCartDTO createNewCart(final ProductDTO productDTO){
        final ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

        final ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
        shoppingCartItemDTO.setProductName(productDTO.getProductName());
        shoppingCartItemDTO.setQuantity(productDTO.getQuantity());
        shoppingCartItemDTO.setLineItemPrice(productDTO.getSupplierPrice());
        shoppingCartItemDTO.setLineItemDiscount(0);
        final double lineItemTotal = productDTO.getQuantity() * productDTO.getSupplierPrice();
        shoppingCartItemDTO.setLineItemTotal(lineItemTotal);

        //here discount needs to be set based on requirement
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

    public  ShoppingCartDTO updateItemQuantity(final ShoppingCartDTO sessionCart, final Long cartItemId, final int quantity){
        List<ShoppingCartItemDTO> shoppingCartItems =  sessionCart.getCartItems();
        Optional<ShoppingCartItemDTO> shoppingCartItemDTO = shoppingCartItems.stream().filter(sci->sci.getItemId() == cartItemId).findFirst();
        shoppingCartItemDTO.get().setQuantity(quantity);
        shoppingCartItemDTO.get().setLineItemTotal(shoppingCartItemDTO.get().getLineItemPrice() * shoppingCartItemDTO.get().getQuantity());
        shoppingCartItems.removeIf(sci->sci.getItemId() == cartItemId);
        shoppingCartItems.add(shoppingCartItemDTO.get());
        sessionCart.setCartTotal(shoppingCartItems.stream().mapToDouble(sci->sci.getLineItemTotal()).sum());
        shoppingCartItems.removeIf(sci->sci.getItemId() == cartItemId);

        sessionCart.setCartItems(shoppingCartItems);
        cartRepository.save(shoppingCartMapper.from(sessionCart));
        return sessionCart;
    }

}
