package com.aska.store.repository;


import com.aska.store.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by askalaveeska on 27/02/19.
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Long>{

    ProductEntity findByProductIdAndIsActiveTrue(final long productId);

    List<ProductEntity> findByProductGroupEntityProductGroupIdAndStoreEntityStoreId(final long productGroupId, final long storeId);

    List<ProductEntity> findByCategoryEntityCategoryId(final long categoryId);

}
