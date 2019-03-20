package com.aska.store.service;

import com.aska.store.model.UserDTO;


public interface UserService {

    UserDTO getUserDetails(final String email, final String password);


}
