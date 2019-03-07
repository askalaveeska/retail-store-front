package com.aska.admin.store.controller;

import com.aska.admin.store.common.Constants;
import com.aska.admin.store.model.UserDTO;
import com.aska.admin.store.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/login")
    public ResponseEntity<UserDTO> authenticateLogin(final HttpServletRequest request, final HttpSession session){

        final String email = (String) request.getAttribute("email");
        final String password = (String) request.getAttribute("password");
        final UserDTO user= userService.getAccountDetails(email,password);
        if (Objects.nonNull(user)){
            session.setAttribute(Constants.USER_OBJECT,user);
            return ResponseEntity.ok(user);
        }
        else{
            return new ResponseEntity(Constants.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
        }
    }
}
