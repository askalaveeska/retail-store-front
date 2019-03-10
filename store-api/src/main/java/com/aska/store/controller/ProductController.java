package com.aska.store.controller;

import com.aska.store.common.RedirectPages;
import com.aska.store.model.ProductDTO;
import com.aska.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("productInifo/{pid}")
    public String getProduct(@PathVariable("pid") long productId, HttpServletRequest request, HttpSession session){
        //gets all the products
        final ProductDTO productDTO = productService.findByProductIdIsActive(productId);
        if(Objects.nonNull(productDTO))
            return RedirectPages.PDP_PAGE;
        else {
            return RedirectPages.COMMON_ERROR_PAGE;
        }
    }
}
