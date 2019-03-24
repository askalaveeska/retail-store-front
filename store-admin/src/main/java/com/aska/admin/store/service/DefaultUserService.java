package com.aska.admin.store.service;

import com.aska.admin.store.entity.UserEntity;
import com.aska.admin.store.mapper.UserMapper;
import com.aska.admin.store.model.UserDTO;
import com.aska.admin.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserDetails(final String email, final String password) {

        final UserEntity userEntity = userRepository.findByEmailAndPasswordAndIsUserTrue(email,password);

        return userMapper.from(userEntity);
    }

    @Override
    public UserDTO getAdminDetails(String email, String password) {
        final UserEntity userEntity = userRepository.findByEmailAndPasswordAndIsAdminTrue(email,password);
        return userMapper.from(userEntity);
    }
}
