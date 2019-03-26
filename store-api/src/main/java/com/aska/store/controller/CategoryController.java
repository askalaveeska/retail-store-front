package com.aska.store.controller;

import com.aska.store.common.Constants;
import com.aska.store.common.RedirectPages;
import com.aska.store.model.CategoryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class CategoryController {
    @GetMapping("category.do")
    public ModelAndView getCat(@SessionAttribute(Constants.CATEGORY_LIST_OBJ)List<CategoryDTO> categories, ModelAndView modelAndView){
        if (Objects.nonNull(categories)) {
            modelAndView.addObject(Constants.CATEGORY_LIST_OBJ, categories);
            modelAndView.setViewName(RedirectPages.CLP_PAGE);
        }
        else {
            modelAndView.setViewName(RedirectPages.COMMON_ERROR_PAGE);
        }
        return modelAndView;
    }
}
