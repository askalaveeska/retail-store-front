package com.aska.admin.store.mapper;

import com.aska.admin.store.entity.StoreEntity;
import com.aska.admin.store.model.StoreDTO;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    public StoreDTO from(final StoreEntity storeEntity){
        final StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreId(storeEntity.getStoreId());
        storeDTO.setStoreId(storeEntity.getStoreId());
        storeDTO.setStoreId(storeEntity.getStoreId());
        return storeDTO;
    }
}
