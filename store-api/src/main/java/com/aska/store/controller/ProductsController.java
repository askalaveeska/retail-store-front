package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.entity.ProductEntity;
import com.aska.store.mapper.ProductMapper;
import com.aska.store.model.ProductDTO;
import com.aska.store.repository.ProductRepository;
import com.aska.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Value("${store.default.page.size}")
    private int pageSize;

    @GetMapping("products.do/{categoryId}/{pageNumber}")
    public ModelAndView get(@PathVariable("categoryId") long categoryId, @PathVariable("pageNumber") int pageNumber,
                            ModelAndView modelAndView){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        final List<ProductEntity> productEntities = productRepository.findAllByCategoryEntityCategoryId(categoryId,pageable);
        final long productCount = productRepository.countByIsActiveTrueAndCategoryEntityCategoryId(categoryId);
        final long nPages = productCount%pageSize==0?productCount/pageSize:(productCount/pageSize)+1;
        final List<ProductDTO> products =  productEntities.stream().map(productMapper::from).collect(Collectors.toList());
        if(products.isEmpty()){
            modelAndView.setViewName(RedirectPages.COMMON_ERROR_PAGE);
        }
        else{
            modelAndView.addObject("currentPage",pageNumber);
            modelAndView.addObject("totalPages",nPages);
            modelAndView.addObject(Constants.PRODUCTS_LIST_OBJ,products);
            modelAndView.setViewName(RedirectPages.PLP_PAGE);
        }
        return modelAndView;
    }
}
