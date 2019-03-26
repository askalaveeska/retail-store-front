package com.aska.store.repository;

import com.aska.store.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    List<CategoryEntity> findAllByStoreEntityStoreId(final long storeId);
    List<CategoryEntity> findDistinctByProductsProductIdIn(final List<Long> productId);
}
