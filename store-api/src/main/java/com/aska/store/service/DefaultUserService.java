package com.aska.store.service;

import com.aska.store.entity.UserEntity;
import com.aska.store.mapper.UserMapper;
import com.aska.store.model.UserDTO;
import com.aska.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<UserDTO> getUserDetails(final String email, final String password) {
        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(email,password);
        if (userEntity.isPresent()){
            final UserDTO  userDTO = userMapper.from(userEntity.get());
            return Optional.ofNullable(userDTO);
        }
        return Optional.empty();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO, final long storeId) {
        if(userRepository.existsByEmailAndStoreEntityStoreId(userDTO.getEmail(),storeId)){
            return null;
        }
        else{
            userDTO.getStoreDTO().setStoreId(storeId);
            final UserEntity userEntity = userMapper.from(userDTO);
            return userMapper.from(userRepository.save(userEntity));
        }

    }
}
