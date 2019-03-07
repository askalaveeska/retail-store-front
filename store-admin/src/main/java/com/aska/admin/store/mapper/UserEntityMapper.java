package com.aska.admin.store.mapper;

import com.aska.admin.store.entity.UserEntity;
import com.aska.admin.store.model.UserDTO;

public interface UserEntityMapper {
    UserDTO from(final UserEntity userEntity);
}
