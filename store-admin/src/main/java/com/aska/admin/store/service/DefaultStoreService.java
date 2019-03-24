package com.aska.admin.store.service;

import com.aska.admin.store.entity.StoreEntity;
import com.aska.admin.store.mapper.StoreMapper;
import com.aska.admin.store.model.StoreDTO;
import com.aska.admin.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultStoreService implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public StoreDTO findByStoreId(long storeId) {
        final StoreEntity storeEntity = storeRepository.findByStoreId(storeId);
        return storeMapper.from(storeEntity);
    }

    @Override
    public StoreEntity save(final StoreDTO storeDTO) {
        return storeRepository.save(storeMapper.from(storeDTO));
    }

}
