package com.aska.store.mapper;

import com.aska.store.entity.StoreEntity;
import com.aska.store.model.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StoreMapper {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    public StoreDTO from(final StoreEntity storeEntity){
        final StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreId(storeEntity.getStoreId());
        storeDTO.setDescription(storeEntity.getDescription());
        storeDTO.setImage(storeEntity.getImage());
        storeDTO.setStoreName(storeEntity.getStoreName());
        storeDTO.setProductGroupId(storeEntity.getProductGroupId());
        storeDTO.setProductGroupId(storeEntity.getProductGroupId());
        storeDTO.setAddressList(storeEntity.getAddressEntities().stream().map(addressMapper::from).collect(Collectors.toList()));
        //storeDTO.setCategories(storeEntity.getCategoryEntities().stream().map(categoryMapper::from).collect(Collectors.toList()));
        return storeDTO;
    }
    public StoreEntity from(final StoreDTO storeDTO){
        final StoreEntity storeEntity = new StoreEntity();
        storeEntity.setStoreId(storeDTO.getStoreId());
        storeEntity.setDescription(storeDTO.getDescription());
        
        storeEntity.setImage(storeDTO.getImage());
        storeEntity.setStoreName(storeDTO.getStoreName());
        storeEntity.setProductGroupId(storeDTO.getProductGroupId());
        storeEntity.setAddressEntities(storeDTO.getAddressList().stream().map(addressMapper::from).collect(Collectors.toList()));
        //storeEntity.setCategoryEntities(storeDTO.getCategories().stream().map(categoryMapper::from).collect(Collectors.toList()));
        return storeEntity;
    }
}
