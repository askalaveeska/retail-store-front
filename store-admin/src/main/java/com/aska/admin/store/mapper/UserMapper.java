package com.aska.admin.store.mapper;

import com.aska.admin.store.entity.UserEntity;
import com.aska.admin.store.model.UserDTO;
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
       return userDTO;
    }
}
