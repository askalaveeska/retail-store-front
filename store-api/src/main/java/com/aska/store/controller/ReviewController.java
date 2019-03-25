package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.AddressDTO;
import com.aska.store.model.ShoppingCartDTO;
import com.aska.store.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Controller
public class ReviewController {
    @GetMapping("review.do")
    public ModelAndView review(@Valid AddressDTO deliveryAddress, BindingResult bindingResult, @SessionAttribute(name = Constants.SESSION_CART) ShoppingCartDTO sessionCart,
                               @SessionAttribute(name = Constants.SESSION_USER) UserDTO sessionUser, ModelAndView modelAndView){
        //Here validate the order details
        if (bindingResult.hasErrors()){
            //add errors to view
        }
        modelAndView.setViewName(RedirectPages.REVIEW_PAGE);
        return modelAndView;
    }
}
