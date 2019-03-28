package com.aska.store.mapper;

import com.aska.store.entity.CategoryEntity;
import com.aska.store.model.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryDTO from(final CategoryEntity categoryEntity) {
        final CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(categoryEntity.getCategoryId());
        categoryDTO.setStoreId(categoryEntity.getStoreId());
        categoryDTO.setDescription(categoryEntity.getDescription());
        categoryDTO.setName(categoryEntity.getName());
        return categoryDTO;
    }

    public CategoryEntity from(final CategoryDTO categoryDTO) {
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(categoryDTO.getCategoryId());
        categoryEntity.setStoreId(categoryDTO.getStoreId());
        categoryEntity.setDescription(categoryDTO.getDescription());
        categoryEntity.setName(categoryDTO.getName());
        return categoryEntity;
    }
}
