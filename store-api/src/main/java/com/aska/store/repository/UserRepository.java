package com.aska.store.repository;

import com.aska.store.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long>{

    UserEntity findByEmailAndPasswordAndIsUserTrue(final String email, final String password);

    UserEntity findByEmailAndPasswordAndIsAdminTrue(final String email, final String password);

}
