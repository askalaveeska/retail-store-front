package com.aska.store.service;

import com.aska.store.model.UserDTO;
import com.aska.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ppalpandi on 3/9/2019.
 */
public class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private
    @Override
    public UserDTO getAccountDetails(String email, String password) {
        return null;
    }
}
