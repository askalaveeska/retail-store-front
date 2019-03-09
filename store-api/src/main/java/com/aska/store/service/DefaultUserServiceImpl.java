package com.aska.store.service;

import com.aska.store.entity.StoreListEntity;
import com.aska.store.entity.UserEntity;
import com.aska.store.model.UserDTO;
import com.aska.store.repository.ProductRepository;
import com.aska.store.repository.StoreListRepository;
import com.aska.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DefaultUserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreListRepository storeListRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public UserDTO getAccountDetails(final String email, final String password) {

        final UserEntity userEntity = userRepository.findByEmailAndPassword(email,password);
        final List<StoreListEntity> storeListEntities = storeListRepository.findAllByUserId(userEntity.getUserId());
        final UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(userEntity.getFirstName());
        return userDTO;
    }
}
