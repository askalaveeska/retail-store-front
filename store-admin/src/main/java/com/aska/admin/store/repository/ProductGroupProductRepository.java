package com.aska.admin.store.repository;

import com.aska.admin.store.entity.ProductGroupProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupProductRepository  extends JpaRepository<ProductGroupProductEntity,Long> {

}
