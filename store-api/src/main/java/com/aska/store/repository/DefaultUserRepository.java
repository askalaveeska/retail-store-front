package com.aska.store.repository;

import com.aska.store.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ppalpandi on 3/8/2019.
 */
@Repository
public class DefaultUserRepository implements UserRepository {

    private UserEntity userEntity;

    @Override
    public UserEntity findByEmailAndPassword(String email, String password) {

        userEntity = new UserEntity();
        userEntity.setEmail("askalaveeska@gmail.com");
        userEntity.setPassword("P@ssw0rd");
        userEntity.setFirstName("Pandiarajan");
        userEntity.setLastName("Palpandi");

        if (email.equalsIgnoreCase("askalaveeska@gmail.com"))
        return userEntity;
        else
            return null;
    }
}
