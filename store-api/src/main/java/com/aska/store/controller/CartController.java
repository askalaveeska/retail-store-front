package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.entity.ProductEntity;
import com.aska.store.entity.ShoppingCartEntity;
import com.aska.store.mapper.ProductMapper;
import com.aska.store.mapper.ShoppingCartMapper;
import com.aska.store.model.ProductDTO;
import com.aska.store.model.ShoppingCartDTO;
import com.aska.store.model.ShoppingCartItemDTO;
import com.aska.store.model.UserDTO;
import com.aska.store.repository.CartItemRepository;
import com.aska.store.repository.CartRepository;
import com.aska.store.service.DefaultCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private DefaultCartService defaultCartService;


    @GetMapping("api/cart")
    public ResponseEntity loadCart(@SessionAttribute(name = Constants.SESSION_USER)UserDTO userDTO,
                                   @SessionAttribute(name = Constants.SESSION_CART) ShoppingCartDTO shoppingCartDTO){

        if (Objects.nonNull(shoppingCartDTO)){
            return ResponseEntity.ok(shoppingCartDTO);
        }
        else{
            final ShoppingCartEntity shoppingCartEntity = cartRepository.findByUserUserId(userDTO.getUserId());
            return ResponseEntity.ok(shoppingCartMapper.from(shoppingCartEntity));
        }

    }

    @PostMapping("api/cart")
    public ResponseEntity addToCart(@Valid @RequestBody ShoppingCartItemDTO shoppingCartItemDTO,
                                    @SessionAttribute(name = Constants.SESSION_USER) UserDTO userDTO,
                                    @SessionAttribute(name = Constants.SESSION_CART) ShoppingCartDTO sessionCart,
                                    HttpSession session){
        final ShoppingCartDTO shoppingCartDTO = defaultCartService.addToCart(userDTO,shoppingCartItemDTO,sessionCart);
        if (Objects.nonNull(shoppingCartDTO)) {
            session.setAttribute(Constants.SESSION_CART,shoppingCartDTO);
            return ResponseEntity.ok(shoppingCartDTO);
        }
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("api/cart/{cartItemId}")
    public ResponseEntity removeFromCart(@PathVariable final long cartItemId, @SessionAttribute(name = Constants.SESSION_CART) ShoppingCartDTO sessionCart,
                                         HttpSession session){
        if (Objects.nonNull(sessionCart)){
            defaultCartService.removeItemFromCart(sessionCart,cartItemId);
            return ResponseEntity.ok(sessionCart);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    public ResponseEntity updateQuantity(final HttpServletRequest request, @SessionAttribute(name = Constants.SESSION_USER) UserDTO userDTO){
        return null;
    }

}
