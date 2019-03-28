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

    public UserDTO from(final UserEntity userEntity){
       final UserDTO userDTO = new UserDTO();
       userDTO.setUserId(userEntity.getUserId());
       userDTO.setStoreId(userEntity.getStoreId());
       userDTO.setEmail(userEntity.getEmail());
       userDTO.setFirstName(userEntity.getFirstName());
       userDTO.setLastName(userEntity.getLastName());
       userDTO.setPassword(userEntity.getPassword());
       userDTO.setPhoneNumber(userEntity.getPhoneNumber());
       userDTO.setUser(userEntity.isUser());
       userDTO.setAdmin(userEntity.isAdmin());
       return userDTO;
    }

    public UserEntity from(final UserDTO userDTO){
        final UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setStoreId(userDTO.getStoreId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setUser(userDTO.isUser());
        userEntity.setAdmin(userDTO.isAdmin());
        return userEntity;
    }

}
