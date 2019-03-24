package com.aska.store.repository;

import com.aska.store.entity.ProductGroupProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupProductRepository  extends JpaRepository<ProductGroupProductEntity,Long> {

}
