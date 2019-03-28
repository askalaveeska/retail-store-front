package com.aska.store.service;

import com.aska.store.entity.CartItemEntity;
import com.aska.store.entity.ProductEntity;
import com.aska.store.entity.ShoppingCartEntity;
import com.aska.store.mapper.ProductMapper;
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
import java.util.stream.Collectors;

@Service
public class DefaultCartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;

    public ShoppingCartDTO getCart(final UserDTO sessionUser, final ShoppingCartDTO sessionCart){
        if (Objects.nonNull(sessionCart)){
            return sessionCart;
        }
        final ShoppingCartEntity shoppingCartEntity = cartRepository.findByUserId(sessionUser.getUserId());
        final List<ShoppingCartItemDTO> shoppingCartItems  = shoppingCartEntity.getCartItems().stream().map(shoppingCartItemMapper::from).collect(Collectors.toList());
        final ShoppingCartDTO shoppingCartDTO =  shoppingCartMapper.from(shoppingCartEntity);
        shoppingCartDTO.setCartItems(shoppingCartItems);
        return shoppingCartDTO;
    }

    public ShoppingCartDTO addToCart(final UserDTO userDTO, final ProductDTO productDTO, final ShoppingCartDTO sessionCart){
        final ProductEntity productEntity = productMapper.from(productDTO);
        final ShoppingCartEntity shoppingCartEntity;
        if (Objects.nonNull(sessionCart)){
            shoppingCartEntity = shoppingCartMapper.from(sessionCart);
        }
        else{
            shoppingCartEntity = cartRepository.findByUserId(userDTO.getUserId());
        }
        if (Objects.nonNull(shoppingCartEntity)){
            final CartItemEntity cartItemEntity =  cartItemRepository.findByProductId(productEntity.getProductId());
            if (Objects.nonNull(cartItemEntity)){
                //can check max allowed quantity
                final ShoppingCartEntity cartEntity = cartItemEntity.getShoppingCart();
                final double cartTotal = cartEntity.getCartTotal() + productEntity.getSupplierPrice();
                //need to calculate discount amount here
                cartEntity.setCartTotal(cartTotal);

                cartItemEntity.setQuantity(cartItemEntity.getQuantity()+productEntity.getQuantity());
                cartItemEntity.setItemTotalPrice(cartItemEntity.getItemTotalPrice()+productEntity.getSupplierPrice());
                cartItemRepository.save(cartItemEntity);
                return shoppingCartMapper.from(cartRepository.save(cartEntity));
            }
            else {
                final CartItemEntity cartItem = getLineItem(productEntity);
                cartItem.setCartId(shoppingCartEntity.getCartId());
                //needs discount calculation here
                shoppingCartEntity.setCartTotal(shoppingCartEntity.getCartTotal() + cartItem.getItemTotalPrice());
                final ShoppingCartEntity cartTemp = cartRepository.save(shoppingCartEntity);
                cartItemRepository.save(cartItem);
                List<CartItemEntity>  itemEntities = new ArrayList<>();
                itemEntities.add(cartItem);
                cartTemp.setCartItems(itemEntities);
                return shoppingCartMapper.from(cartTemp);
            }
        }

        else {
            final CartItemEntity cartItemEntity = getLineItem(productEntity);
            final ShoppingCartEntity cartEntity =  createNewCart(cartItemEntity,userDTO);
            final ShoppingCartEntity cartTemp = cartRepository.save(cartEntity);
            cartItemEntity.setCartId(cartTemp.getCartId());
            cartItemRepository.save(cartItemEntity);
            List<CartItemEntity> cartItemEntities = new ArrayList<>();
            cartItemEntities.add(cartItemEntity);
            cartEntity.setCartItems(cartItemEntities);
            return shoppingCartMapper.from(cartTemp);
        }

    }

    private CartItemEntity getLineItem(final ProductEntity productEntity){
        final CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setProductId(productEntity.getProductId());
        cartItemEntity.setProductName(productEntity.getProductName());
        cartItemEntity.setQuantity(productEntity.getQuantity());
        cartItemEntity.setItemPrice(productEntity.getSupplierPrice());
        cartItemEntity.setItemDiscount(0);
        final double lineItemTotal = productEntity.getQuantity() * productEntity.getSupplierPrice();
        cartItemEntity.setItemTotalPrice(lineItemTotal);
        return cartItemEntity;
    }

    private ShoppingCartEntity createNewCart(CartItemEntity cartItemEntity, final UserDTO userDTO){
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setUserId(userDTO.getUserId());
        shoppingCartEntity.setCartTotal(cartItemEntity.getItemTotalPrice());
        //here discount needs to be set based on requirement
        shoppingCartEntity.setDiscountAmount(0);
        return shoppingCartEntity;
    }

    public  ShoppingCartDTO removeItemFromCart(final ShoppingCartDTO sessionCart, final Long cartItemId){
        cartItemRepository.deleteById(cartItemId);
        List<ShoppingCartItemDTO> shoppingCartItems =  sessionCart.getCartItems();
        Optional<ShoppingCartItemDTO> shoppingCartItemDTO = shoppingCartItems.stream().filter(sci->sci.getItemId() == cartItemId).findFirst();
        sessionCart.setCartTotal(sessionCart.getCartTotal()-shoppingCartItemDTO.get().getLineItemTotal());
        shoppingCartItems.removeIf(sci->sci.getItemId() == cartItemId);
        sessionCart.setCartItems(shoppingCartItems);
        final ShoppingCartEntity shoppingCartEntity = shoppingCartMapper.from(sessionCart);
        cartRepository.save(shoppingCartEntity);
        return sessionCart;
    }

    public  ShoppingCartDTO updateItemQuantity(final ShoppingCartDTO sessionCart, final Long cartItemId, final int quantity){

        final ShoppingCartEntity shoppingCartEntity = shoppingCartMapper.from(sessionCart);
        List<CartItemEntity> shoppingCartItems =  shoppingCartEntity.getCartItems();
        Optional<CartItemEntity> cartItemEntity = shoppingCartItems.stream().filter(sci->sci.getItemId() == cartItemId).findFirst();
        cartItemEntity.get().setQuantity(quantity);
        cartItemEntity.get().setItemTotalPrice(cartItemEntity.get().getItemPrice() * cartItemEntity.get().getQuantity());
        shoppingCartItems.removeIf(sci->sci.getItemId() == cartItemId);
        shoppingCartItems.add(cartItemEntity.get());
        shoppingCartEntity.setCartTotal(shoppingCartItems.stream().mapToDouble(sci->sci.getItemTotalPrice()).sum());
        shoppingCartItems.removeIf(sci->sci.getItemId() == cartItemId);

        cartItemRepository.saveAll(shoppingCartItems);
        shoppingCartEntity.setCartItems(shoppingCartItems);
        cartRepository.save(shoppingCartEntity);
        return sessionCart;
    }

}
