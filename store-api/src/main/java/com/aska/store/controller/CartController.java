package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.ContentType;
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


    @GetMapping("launchCart.do")
    public ModelAndView loadCart(@SessionAttribute(name = Constants.SESSION_USER)UserDTO sessionUser,
                                 @SessionAttribute(name = Constants.SESSION_CART, required = false) ShoppingCartDTO sessionCart,
                                 ModelAndView modelAndView){

        final ShoppingCartDTO cartDTO = defaultCartService.getCart(sessionUser,sessionCart);
        modelAndView.addObject(Constants.CART_OBJ,cartDTO);
        modelAndView.setViewName(RedirectPages.CART_PAGE);
        return modelAndView;

    }

    @PostMapping(value = "pushToCart.do")
    public ModelAndView addToCart(@Valid ProductDTO productDTO,
                                    @SessionAttribute(name = Constants.SESSION_USER) UserDTO sessionUser,
                                    @SessionAttribute(name = Constants.SESSION_CART , required = false) ShoppingCartDTO sessionCart,
                                    ModelAndView modelAndView, HttpSession session){
        //need to check if it really updates session cart object
        final ShoppingCartDTO shoppingCartDTO  = defaultCartService.addToCart(sessionUser,productDTO,sessionCart);
        session.setAttribute(Constants.SESSION_CART,shoppingCartDTO);
        modelAndView.addObject(Constants.CART_OBJ,shoppingCartDTO);
        modelAndView.setViewName(RedirectPages.CART_PAGE);
        return modelAndView;
    }

    @DeleteMapping("removeItem.do/{cartItemId}")
    public ModelAndView removeFromCart(@PathVariable("cartItemId") final long cartItemId, @SessionAttribute(name = Constants.SESSION_CART) ShoppingCartDTO sessionCart,
                                         HttpSession session,ModelAndView modelAndView){
        final ShoppingCartDTO shoppingCartDTO  = defaultCartService.removeItemFromCart(sessionCart,cartItemId);
        modelAndView.addObject(Constants.CART_OBJ,shoppingCartDTO);
        session.setAttribute(Constants.SESSION_CART,shoppingCartDTO);
        modelAndView.setViewName(RedirectPages.CART_PAGE);
        return modelAndView;

    }

    @PostMapping("updateQuantity.do")
    public ModelAndView updateQuantity(@RequestParam("cartItemId") final long cartItemId, @RequestParam("quantity") final int quantity,
                                         @SessionAttribute(name = Constants.SESSION_CART) ShoppingCartDTO sessionCart, ModelAndView modelAndView,HttpSession session){
        final ShoppingCartDTO shoppingCartDTO = defaultCartService.updateItemQuantity(sessionCart,cartItemId,quantity);
        modelAndView.addObject(Constants.CART_OBJ,shoppingCartDTO);
        session.setAttribute(Constants.SESSION_CART,shoppingCartDTO);
        modelAndView.setViewName(RedirectPages.CART_PAGE);
        return modelAndView;
    }

}
