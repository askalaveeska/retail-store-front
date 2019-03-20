package com.aska.store.repository;

import com.aska.store.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Repository
public interface AddressRepository extends CrudRepository<AddressEntity,Long>{

    List<AddressEntity> findAllByUserEmail(final String email);

}
