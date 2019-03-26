package com.aska.store.repository;

import com.aska.store.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmailAndPassword(final String email, final String password);

    Optional<UserEntity> findByEmailAndPasswordAndIsAdminTrue(final String email, final String password);

    boolean existsByEmailAndStoreEntityStoreId(final String email, final long storeId);

}
