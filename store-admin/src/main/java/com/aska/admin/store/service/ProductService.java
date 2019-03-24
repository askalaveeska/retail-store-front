package com.aska.admin.store.service;

import com.aska.admin.store.entity.ProductEntity;
import com.aska.admin.store.model.ProductDTO;

import java.util.List;

/**
 * Created by askalaveeska on 26/02/19.
 */

public interface ProductService {

    ProductDTO findByProductId(final long productId);

    List<ProductDTO> findAllByCategoryEntityCategoryId(final long categoryId);

    List<ProductDTO> findAllByProductId(List<Long> productId);

    List<ProductDTO> findAllByBrandEntityBrandId(final long brandId);
}
