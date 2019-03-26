package com.aska.store.service;

import com.aska.store.model.UserDTO;

import java.util.Optional;


public interface UserService {

    Optional<UserDTO> getUserDetails(final String email, final String password);

    UserDTO createUser(final UserDTO userDTO, final long storeId);

}
