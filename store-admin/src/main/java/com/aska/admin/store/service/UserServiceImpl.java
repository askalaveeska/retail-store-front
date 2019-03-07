package com.aska.admin.store.service;

import com.aska.admin.store.entity.UserEntity;
import com.aska.admin.store.model.UserDTO;
import com.aska.admin.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getAccountDetails(final String email,final String password) {

        final UserEntity userEntity = userRepository.findByEmailAndPassword(email,password);

        return new UserDTO();
    }
}
