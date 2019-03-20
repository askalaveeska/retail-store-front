package com.aska.store.repository;

import com.aska.store.entity.ProductGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Repository
public interface ProductGroupRepository extends CrudRepository<ProductGroupEntity,Long> {

    ProductGroupEntity findByStoreEntityStoreId(final long storeId);
    ProductGroupEntity findByProductGroupId(final long productGroupId);

}
