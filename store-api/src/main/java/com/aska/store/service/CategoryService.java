package com.aska.store.service;

import com.aska.store.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO getCategory(final long categoryId);
    List<CategoryDTO> getCategories(final long storeId);
}
