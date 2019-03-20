package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.model.ProductDTO;
import com.aska.store.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public ResponseEntity loadCart(final HttpServletRequest request, @SessionAttribute(name = Constants.SESSION_USER)UserDTO user){

        return null;
    }

    public ResponseEntity aadToCart(final HttpServletRequest request, @SessionAttribute(name = Constants.SESSION_USER) UserDTO user, ProductDTO product){
        return null;
    }

    public ResponseEntity removeFromCart(final HttpServletRequest request, @SessionAttribute(name = Constants.SESSION_USER) UserDTO user){
        return null;
    }

}
