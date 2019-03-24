package com.aska.admin.store.service;

import com.aska.admin.store.entity.StoreEntity;
import com.aska.admin.store.model.StoreDTO;

public interface StoreService {
    StoreDTO findByStoreId(final long storeId);
    StoreEntity save(final StoreDTO storeDTO);
}
