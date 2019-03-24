package com.aska.store.repository;


import com.aska.store.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by askalaveeska on 27/02/19.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    ProductEntity findByProductId(final long productId);

    List<ProductEntity> findAllByCategoryEntityCategoryId(final long categoryId);

    List<ProductEntity> findAllByProductId(List<Long> productId);

    List<ProductEntity> findAllByBrandEntityBrandId(final long brandId);

    boolean existsByProductName(final String productName);

}
