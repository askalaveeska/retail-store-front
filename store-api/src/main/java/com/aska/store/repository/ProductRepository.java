package com.aska.store.repository;


import com.aska.store.entity.CategoryEntity;
import com.aska.store.entity.ProductEntity;
import com.aska.store.model.CategoryDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by askalaveeska on 27/02/19.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Long countByIsActiveTrueAndCategoryEntityCategoryId(final long categoryId);

    ProductEntity findByProductIdAndIsActiveTrue(final long productId);

    ProductEntity findByProductId(final long productId);

    List<ProductEntity> findAllByCategoryEntityCategoryId(final long categoryId, Pageable pageable);

    List<ProductEntity> findAllByProductId(List<Long> productId);

    List<ProductEntity> findAllByBrandEntityId(final long brandId);

    boolean existsByProductName(final String productName);

    List<CategoryEntity> findAllCategoryEntityByProductId(final List<Long> productId);

}
