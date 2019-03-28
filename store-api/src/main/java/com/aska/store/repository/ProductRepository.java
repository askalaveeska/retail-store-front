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

    Long countByIsActiveTrueAndCategoryId(final long categoryId);

    ProductEntity findByProductIdAndIsActiveTrue(final long productId);

    ProductEntity findByProductId(final long productId);

    List<ProductEntity> findAllByCategoryId(final long categoryId, final Pageable pageable);

    List<ProductEntity> findAllByProductId(final List<Long> productId, final Pageable pageable);

    List<ProductEntity> findAllByBrandEntityId(final long brandId);

    boolean existsByProductName(final String productName);

}
