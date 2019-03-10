package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.Error;
import com.aska.store.model.LoginDTO;
import com.aska.store.model.ProductGroupDTO;
import com.aska.store.model.UserDTO;
import com.aska.store.service.ProductGroupService;
import com.aska.store.service.UserService;
import com.aska.store.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductGroupService productGroupService;

    @Value("${cuurent.store.id}")
    private long storeId;

    @GetMapping({"/","/landing.action"})
    public String getLanding(Model model){
        model.addAttribute(Constants.LOGIN_OBJECT,new LoginDTO());
        return RedirectPages.LANDING_PAGE;
    }

    @PostMapping("/login.action")
    public String authorize(@Valid LoginDTO login, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession httpSession){
        Set<Error> errors;
        if(bindingResult.hasErrors()){
            errors = StoreUtil.getErrorResponse(bindingResult);
            model.addAttribute(Constants.LOGIN_OBJECT,login);
            model.addAttribute(Constants.ERROR_OBJECT, errors);
            return RedirectPages.LANDING_PAGE;
        }
        final UserDTO userDTO = userService.getAccountDetails(login.getEmail(),login.getPassword());
            if(Objects.nonNull(userDTO)){
                final ProductGroupDTO productGroupDTO = productGroupService.findByStoreId(storeId);
                httpSession.setAttribute(Constants.SESSION_USER,userDTO);
                model.addAttribute(Constants.PRODUCTS_LIST,productGroupDTO);
                return RedirectPages.PLP_PAGE;
            }
        else {
                final Error error = new Error();
                error.setMessage("Invalid Email id or Password");
                model.addAttribute(error);
                return RedirectPages.LANDING_PAGE;
            }
    }
    @PostMapping("/logout.out")
    public String logout(HttpServletRequest request,HttpSession httpSession){
        httpSession.invalidate();
        return RedirectPages.LANDING_PAGE;
    }
}
