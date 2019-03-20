package com.aska.admin.store.service;

import com.aska.admin.store.model.UserDTO;


public interface UserService {

    UserDTO getUserDetails(final String email, final String password);

}
