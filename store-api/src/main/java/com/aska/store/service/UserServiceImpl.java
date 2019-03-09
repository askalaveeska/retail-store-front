package com.aska.store.service;

import com.aska.store.entity.UserEntity;
import com.aska.store.model.UserDTO;
import com.aska.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getAccountDetails(final String email, final String password) {

        final UserEntity userEntity = userRepository.findByEmailAndPassword(email,password);

        final UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(userEntity.getFirstName());
        return userDTO;
    }
}
