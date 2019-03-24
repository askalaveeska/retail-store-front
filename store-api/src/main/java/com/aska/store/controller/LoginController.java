package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.entity.StoreEntity;
import com.aska.store.model.Error;
import com.aska.store.model.LoginDTO;
import com.aska.store.model.ProductGroupDTO;
import com.aska.store.model.UserDTO;
import com.aska.store.service.ProductGroupService;
import com.aska.store.service.UserService;
import com.aska.store.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Value("${current.store.id}")
    private long storeId;

    @PostMapping("/api/login")
    public ResponseEntity authorize(@Valid @RequestBody final LoginDTO loginDTO, BindingResult bindingResult,HttpSession session){

        if(bindingResult.hasErrors()){
            Set<Error> errors = StoreUtil.getErrorResponse(bindingResult);
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errors);
        }

        final UserDTO userDTO =  userService.getUserDetails(loginDTO.getEmail(),loginDTO.getPassword());
        if(userDTO.isUser()){
            session.setAttribute(Constants.SESSION_USER,userDTO);
            return ResponseEntity.ok(userDTO);
            }
        else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(StoreUtil.getErrorObject("Invalid username or password!"));
            }
    }
    @PostMapping("/logout.out")
    public String logout(HttpServletRequest request,HttpSession httpSession){
        httpSession.invalidate();
        return RedirectPages.LANDING_PAGE;
    }
}
