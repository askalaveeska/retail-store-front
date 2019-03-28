package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.entity.ProductEntity;
import com.aska.store.mapper.ProductMapper;
import com.aska.store.model.CategoryDTO;
import com.aska.store.model.ProductDTO;
import com.aska.store.model.ProductGroupDTO;
import com.aska.store.model.UserDTO;
import com.aska.store.repository.CategoryRepository;
import com.aska.store.repository.ProductRepository;
import com.aska.store.service.ProductGroupService;
import com.aska.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
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
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductGroupService productGroupService;

    @Value("${store.default.page.size}")
    private int pageSize;

    @GetMapping("products.do/{categoryId}/{pageNumber}")
    public ModelAndView get(@PathVariable("categoryId") long categoryId, @PathVariable("pageNumber") int pageNumber,
                            ModelAndView modelAndView){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        final List<ProductDTO> products = productService.findAllByCategoryId(categoryId,pageable);
        final long productCount = productRepository.countByIsActiveTrueAndCategoryId(categoryId);
        final long nPages = productCount%pageSize==0?productCount/pageSize:(productCount/pageSize)+1;
        if(products.isEmpty()){
            modelAndView.setViewName(RedirectPages.COMMON_ERROR_PAGE);
        }
        else{
            modelAndView.addObject("currentPage",pageNumber);
            modelAndView.addObject("totalPages",nPages);
            modelAndView.addObject("categoryName",categoryRepository.findById(products.get(0).getCategoryId()).get().getName());
            modelAndView.addObject(Constants.PRODUCTS_LIST_OBJ,products);
            modelAndView.setViewName(RedirectPages.PLP_PAGE);
        }
        return modelAndView;
    }

    @GetMapping("allProducts.do/{pageNumber}")
    public ModelAndView getAll(@PathVariable("categoryId") long categoryId, @PathVariable("pageNumber") int pageNumber,
                               ModelAndView modelAndView, @SessionAttribute(Constants.SESSION_USER)UserDTO sessionUser){
        if (Objects.nonNull(sessionUser)){
            final ProductGroupDTO productGroup = productGroupService.findByStoreId(sessionUser.getStoreId());
            final List<Long> productIds = productService.getAllProductIdsByProductGroupId(productGroup.getProductGroupId());


            Pageable pageable = PageRequest.of(pageNumber,pageSize);
            final List<ProductDTO> products = productService.findAllByProductId(productIds,pageable);
            final long productCount = productRepository.countByIsActiveTrueAndCategoryId(categoryId);
            final long nPages = productCount%pageSize==0?productCount/pageSize:(productCount/pageSize)+1;
            if(products.isEmpty()){
                modelAndView.setViewName(RedirectPages.COMMON_ERROR_PAGE);
            }
            else{
                modelAndView.addObject("currentPage",pageNumber);
                modelAndView.addObject("totalPages",nPages);
                modelAndView.addObject("categoryName",categoryRepository.findById(products.get(0).getCategoryId()).get().getName());
                modelAndView.addObject(Constants.PRODUCTS_LIST_OBJ,products);
                modelAndView.setViewName(RedirectPages.PLP_PAGE);
            }
        }
        else{
            modelAndView.setViewName(RedirectPages.COMMON_ERROR_PAGE);
        }

        return modelAndView;
    }
}
