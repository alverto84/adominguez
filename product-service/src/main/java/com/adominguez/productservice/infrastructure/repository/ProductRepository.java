package com.adominguez.productservice.infrastructure.repository;

import com.adominguez.productservice.infrastructure.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
