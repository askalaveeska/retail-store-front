package com.aska.store.mapper;

import com.aska.store.entity.UserEntity;
import com.aska.store.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Component
public class UserMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private StoreMapper storeMapper;

    public UserDTO from(final UserEntity userEntity){
       final UserDTO userDTO = new UserDTO();
       userDTO.setUserId(userEntity.getUserId());
       userDTO.setEmail(userEntity.getEmail());
       userDTO.setFirstName(userEntity.getFirstName());
       userDTO.setLastName(userEntity.getLastName());
       userDTO.setPassword(userEntity.getPassword());
       userDTO.setPhoneNumber(userEntity.getPhoneNumber());
       userDTO.setUser(userEntity.isUser());
       userDTO.setAdmin(userEntity.isAdmin());
        userDTO.setAddressList(userEntity.getAddressEntity().stream().map(addressMapper::from).collect(Collectors.toList()));
        userDTO.setStoreDTO(storeMapper.from(userEntity.getStoreEntity()));
       return userDTO;
    }

    public UserEntity from(final UserDTO userDTO){
        final UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setUser(userDTO.isUser());
        userEntity.setAdmin(userDTO.isAdmin());
        userEntity.setAddressEntity(userDTO.getAddressList().stream().map(addressMapper::from).collect(Collectors.toList()));
        userEntity.setStoreEntity(storeMapper.from(userDTO.getStoreDTO()));
        return userEntity;
    }

}
