package com.aska.admin.store.mapper;

import com.aska.admin.store.entity.UserEntity;
import com.aska.admin.store.model.UserDTO;

public class DefaultUserEntityMapper implements UserEntityMapper{

    @Override
    public UserDTO from(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        return userDTO;
    }

}
