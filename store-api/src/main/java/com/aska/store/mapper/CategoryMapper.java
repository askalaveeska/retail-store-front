package com.aska.store.mapper;

import com.aska.store.entity.CategoryEntity;
import com.aska.store.model.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StoreMapper storeMapper;

    public CategoryDTO from(final CategoryEntity categoryEntity) {
        final CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(categoryEntity.getCategoryId());
        categoryDTO.setDescription(categoryEntity.getDescription());
        categoryDTO.setName(categoryEntity.getName());
        //categoryDTO.setProducts(categoryEntity.getProducts().stream().map(productMapper::from).collect(Collectors.toList()));
        categoryDTO.setStoreDTO(storeMapper.from(categoryEntity.getStoreEntity()));
        return categoryDTO;
    }

    public CategoryEntity from(final CategoryDTO categoryDTO) {
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(categoryDTO.getCategoryId());
        categoryEntity.setDescription(categoryDTO.getDescription());
        categoryEntity.setName(categoryDTO.getName());
        //categoryEntity.setProducts(categoryDTO.getProducts().stream().map(productMapper::from).collect(Collectors.toList()));
        categoryEntity.setStoreEntity(storeMapper.from(categoryDTO.getStoreDTO()));
        return categoryEntity;
    }
}
