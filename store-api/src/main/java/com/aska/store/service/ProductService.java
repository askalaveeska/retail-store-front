package com.aska.store.service;

import com.aska.store.entity.ProductEntity;
import com.aska.store.model.CategoryDTO;
import com.aska.store.model.ProductDTO;
import com.aska.store.repository.ProductRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by askalaveeska on 26/02/19.
 */

public interface ProductService {

    ProductDTO findByProductIdIsActive(final long productId);

    List<ProductDTO> findByCategoryId(final long categoryId);

    ProductDTO findByProductIdAndIsActiveTrue(final long productId);

    ProductDTO findByProductId(final long productId);

    List<ProductDTO> findAllByCategoryEntityCategoryId(final long categoryId);

    List<ProductDTO> findAllByProductId(List<Long> productId);

    List<ProductDTO> findAllByBrandEntityId(final long brandId);

    boolean existsByProductName(final String productName);

    List<Long> getAllProductIdsByProductGroupId(final long productGroupId);

    List<CategoryDTO> getCategoriesByProductIds(List<Long> productIds);
}
