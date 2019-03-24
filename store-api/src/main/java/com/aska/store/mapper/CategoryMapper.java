package com.aska.store.mapper;

import com.aska.store.entity.CategoryEntity;
import com.aska.store.model.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class CategoryMapper {

    @Autowired
    private ProductMapper productMapper;

    public CategoryDTO from(final CategoryEntity categoryEntity) {
        final CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(categoryEntity.getCategoryId());
        categoryDTO.setDescription(categoryEntity.getDescription());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setProducts(categoryEntity.getProducts().stream().map(productMapper::from).collect(Collectors.toList()));
        return categoryDTO;
    }

    public CategoryEntity from(final CategoryDTO categoryDTO) {
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(categoryDTO.getCategoryId());
        categoryEntity.setDescription(categoryDTO.getDescription());
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setProducts(categoryDTO.getProducts().stream().map(productMapper::from).collect(Collectors.toList()));
        return categoryEntity;
    }
}
