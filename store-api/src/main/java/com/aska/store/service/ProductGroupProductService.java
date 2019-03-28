package com.aska.store.service;

import com.aska.store.entity.ProductGroupProductEntity;
import com.aska.store.model.ProductGroupProductDTO;

import java.util.List;

public interface ProductGroupProductService {
    List<ProductGroupProductDTO> findByProductGroupId(final long productGroupId);
}
