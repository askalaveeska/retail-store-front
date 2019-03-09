package com.aska.store.repository;


import com.aska.store.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by askalaveeska on 27/02/19.
 */
@Repository
public interface ProductRepository extends CrudRepository{

    ProductEntity findByProductIdIsActive(final long productId);

    List<ProductEntity> findByProductGroupIdAndStoreId(final long productGroupId, final long storeId);

    List<ProductEntity> findByCategoryId(final long categoryId);

}
