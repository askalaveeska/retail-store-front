package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.AddressDTO;
import com.aska.store.model.OrderDTO;
import com.aska.store.model.ShoppingCartDTO;
import com.aska.store.model.UserDTO;
import com.aska.store.service.OrderService;
import com.aska.store.transformer.ShoppingCartToOrderTransformer;
import com.aska.store.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Controller
public class PlaceOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShoppingCartToOrderTransformer shoppingCartToOrderTransformer;

    @PostMapping("/placeOrder.do")
    public ModelAndView placeOrder(@Valid AddressDTO deliveryAddress,
                                   @SessionAttribute(name = Constants.SESSION_CART )ShoppingCartDTO sessionCart,
                                   @SessionAttribute(name = Constants.SESSION_USER ) UserDTO sessionUser,
                                   ModelAndView modelAndView){
        if (Objects.nonNull(sessionCart)){
            final OrderDTO orderDTO = shoppingCartToOrderTransformer.transform(sessionCart,deliveryAddress,sessionUser);
            final OrderDTO order= orderService.placeOrder(orderDTO);
            modelAndView.addObject(Constants.ORDER_ID,order.getOrderId());
            modelAndView.addObject(Constants.ORDER_ID,order.getOrderEmail());
            modelAndView.setViewName(RedirectPages.CONFIRMATION_PAGE);
        }
        else {
            modelAndView.addObject(StoreUtil.getErrorObject("Place order failed, no session found"));
        }
        return modelAndView;
    }
}
