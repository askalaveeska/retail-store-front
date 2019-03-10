package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.ProductGroupDTO;
import com.aska.store.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Controller
public class ProductGroupController {

    @Autowired
    private ProductGroupService productGroupService;

    @GetMapping("/productGroup/{id}")
    public String getProductGroup(@PathVariable("id")long productGroupId, HttpServletRequest request, Model model){
        final ProductGroupDTO productGroupDTO = productGroupService.findByProductGroupId(productGroupId);
        if(Objects.nonNull(productGroupDTO)){
            model.addAttribute(Constants.PRODUCT_GROUP_OBJECT,productGroupDTO);
            return RedirectPages.PLP_PAGE;
        }
        return RedirectPages.COMMON_ERROR_PAGE;
    }

}
