package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.entity.ProductEntity;
import com.aska.store.mapper.ProductMapper;
import com.aska.store.model.ProductDTO;
import com.aska.store.repository.ProductRepository;
import com.aska.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by askalaveeska on 26/02/19.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("product.do")
    public ModelAndView getProduct(@RequestParam("productId") final long productId, ModelAndView modelAndView){
        final ProductDTO product = productService.findByProductId(productId);
        if (Objects.nonNull(product)){
            modelAndView.addObject(Constants.PRODUCT_OBJ,product);
            modelAndView.setViewName(RedirectPages.PDP_PAGE);
        }
        else {
            modelAndView.setViewName(RedirectPages.COMMON_ERROR_PAGE);
        }
        return modelAndView;
    }

}
