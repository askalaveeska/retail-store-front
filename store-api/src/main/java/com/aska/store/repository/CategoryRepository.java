package com.aska.store.repository;

import com.aska.store.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity,Long> {
    List<CategoryEntity> findAllByStoreEntityStoreId(final long storeId);
}
