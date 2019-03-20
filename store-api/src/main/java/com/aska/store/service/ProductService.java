package com.aska.store.service;

import com.aska.store.model.ProductDTO;

import java.util.List;

/**
 * Created by askalaveeska on 26/02/19.
 */

public interface ProductService {

    ProductDTO findByProductIdIsActive(final long productId);

    List<ProductDTO> findByCategoryId(final long categoryId);
}
