package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.ProductDTO;
import com.aska.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{categoryId}")
    public String get(@PathVariable("categoryId") long categoryId, Model model){
        final List<ProductDTO> products =  productService.findByCategoryId(categoryId);
        if(!products.isEmpty()){
            model.addAttribute(Constants.PRODUCTS_LIST,products);
            return RedirectPages.PLP_PAGE;
        }
        else{
            return  RedirectPages.COMMON_ERROR_PAGE;
        }

    }
}
