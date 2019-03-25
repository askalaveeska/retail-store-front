package com.aska.store.repository;

import com.aska.store.entity.ProductGroupProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductGroupProductRepository  extends JpaRepository<ProductGroupProductEntity,Long> {

    List<Long> findAllProductIdByProductGroupEntityProductGroupId(final long productGroupId);

}
