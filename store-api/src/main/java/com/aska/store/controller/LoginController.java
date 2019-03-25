package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.entity.StoreEntity;
import com.aska.store.model.*;
import com.aska.store.model.Error;
import com.aska.store.service.CategoryService;
import com.aska.store.service.ProductGroupService;
import com.aska.store.service.ProductService;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Value("${current.store.id}")
    private long storeId;

    @GetMapping({"/"})
    public String home(final Model model){
        model.addAttribute(Constants.LOGIN_OBJ,new LoginDTO());
        return RedirectPages.LANDING_PAGE;
    }

    @PostMapping("login.do")
    public ModelAndView authorize(@Valid final LoginDTO loginDTO, BindingResult bindingResult, HttpSession session, ModelAndView modelAndView){

        if(bindingResult.hasErrors()){
            Set<Error> errors = StoreUtil.getErrorResponse(bindingResult);
            modelAndView.addObject(Constants.ERROR_OBJ,errors);
        }

        final UserDTO userDTO =  userService.getUserDetails(loginDTO.getEmail(),loginDTO.getPassword());
        if(userDTO.isUser()){

            final ProductGroupDTO productGroup = productGroupService.findByStoreId(userDTO.getStoreDTO().getStoreId());
            final List<Long> productIds = productService.getAllProductIdsByProductGroupId(productGroup.getProductGroupId());
            final List<CategoryDTO> categories =  productService.getCategoriesByProductIds(productIds);

            session.setAttribute(Constants.SESSION_USER,userDTO);

            modelAndView.addObject(Constants.CATEGORY_LIST_OBJ,categories);
            modelAndView.addObject(Constants.USER_OBJ,userDTO);
            modelAndView.setViewName(RedirectPages.CLP_PAGE);
            }
        else {
            modelAndView.addObject(StoreUtil.getErrorObject("Invalid Username or Password!"));
            modelAndView.setViewName(RedirectPages.LANDING_PAGE);
            }
        return modelAndView;
    }
    @GetMapping("logout.do")
    public ResponseEntity logout(HttpSession httpSession){
        httpSession.invalidate();
        return ResponseEntity.ok().build();
    }
}
