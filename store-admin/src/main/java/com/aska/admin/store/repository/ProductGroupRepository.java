package com.aska.admin.store.repository;

import com.aska.admin.store.entity.ProductGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Repository
public interface ProductGroupRepository extends CrudRepository<ProductGroupEntity,Long> {

    List<ProductGroupEntity> findAllByStoreEntityStoreId(final long storeId);
    ProductGroupEntity findByProductGroupId(final long productGroupId);
    boolean existsByProductGroupName(final String productGroupName);

}
