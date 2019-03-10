package com.aska.store.service;

import com.aska.store.model.UserDTO;


public interface UserService {

    UserDTO getAccountDetails(final String email, final String password, final long storeId);


}
