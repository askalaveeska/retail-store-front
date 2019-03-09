package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.LoginDTO;
import com.aska.store.model.UserDTO;
import com.aska.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    private LoginDTO loginDTO;
    @Autowired
    private UserService userService;

    @GetMapping({"/","/landing.action"})
    public String getLanding(Model model){
        model.addAttribute(Constants.LOGIN_OBJECT,new LoginDTO());
        return RedirectPages.LANDING_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String letMeIn(@Valid LoginDTO loginDTO, BindingResult bindingResult, Model model, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return RedirectPages.LANDING_PAGE;
        }
        final UserDTO userDTO = userService.getAccountDetails(loginDTO.getEmail(),loginDTO.getPassword());
            if(Objects.nonNull(userDTO)){
                model.addAttribute(Constants.USER,userDTO);
                return RedirectPages.PLP_PAGE;
            }
        else {
                return RedirectPages.LANDING_PAGE;
            }
    }
}
