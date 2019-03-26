package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.UserDTO;
import com.aska.store.service.UserService;
import com.aska.store.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountController {

    @Value("${current.store.id}")
    private long storeId;

    @Autowired
    private UserService userService;

    @GetMapping("/registerPage.do")
    public ModelAndView registration(ModelAndView modelAndView){
        modelAndView.addObject(Constants.USER_OBJ, new UserDTO());
        modelAndView.setViewName(RedirectPages.REGISTER_PAGE);
        return modelAndView;
    }

    @PostMapping("createAccount.do")
    public ModelAndView createAccount(@Valid UserDTO newUser, BindingResult bindingResult, ModelAndView modelAndView){
        if (bindingResult.hasErrors()){
            modelAndView.addObject(Constants.ERROR_OBJ, StoreUtil.getErrorResponse(bindingResult));
        }
        else{
            userService.createUser(newUser,storeId);
            modelAndView.addObject(Constants.MESSAGE,StoreUtil.getMessageResponse("message","Account created, Please login."));
            modelAndView.setViewName(RedirectPages.LANDING_PAGE);
        }
       return modelAndView;
    }

}
