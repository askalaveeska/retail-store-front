package com.aska.admin.store.service;

import com.aska.store.entity.UserEntity;
import com.aska.store.mapper.UserMapper;
import com.aska.store.model.UserDTO;
import com.aska.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserDetails(final String email, final String password) {

        final UserEntity userEntity = userRepository.findByEmailAndPasswordAndIsUserTrue(email,password);

        return userMapper.from(userEntity);
    }
}
