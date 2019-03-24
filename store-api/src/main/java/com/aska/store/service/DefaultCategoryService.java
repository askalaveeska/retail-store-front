package com.aska.store.service;

import com.aska.store.entity.CategoryEntity;
import com.aska.store.mapper.CategoryMapper;
import com.aska.store.model.CategoryDTO;
import com.aska.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCategoryService implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO getCategory(long categoryId) {
        return null;
    }

    @Override
    public List<CategoryDTO> getCategories(long storeId) {
        final List<CategoryEntity> categoryEntities =  categoryRepository.findAllByStoreEntityStoreId(storeId);
        return categoryEntities.stream().map(categoryMapper::from).collect(Collectors.toList());
    }
}
