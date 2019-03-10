package com.aska.store.repository;

import com.aska.store.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ppalpandi on 3/10/2019.
 */
@Repository
public interface StoreRepository extends CrudRepository{
    StoreEntity findByStoreId(final long storeId);
}
