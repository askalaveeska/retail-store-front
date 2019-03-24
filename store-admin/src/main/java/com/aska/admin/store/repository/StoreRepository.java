package com.aska.admin.store.repository;

import com.aska.admin.store.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Repository
public interface StoreRepository extends CrudRepository<StoreEntity,Long>{

    StoreEntity findByStoreId(final long storeId);
    boolean existsByStoreName(final String storeName);

}
