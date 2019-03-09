package com.aska.store.repository;

import com.aska.store.entity.UserEntity;


public interface UserRepository {

    UserEntity findByEmailAndPassword(final String email, final String password);

}
