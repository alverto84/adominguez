package com.adominguez.productservice.infrastructure.repository;

import com.adominguez.productservice.infrastructure.repository.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {

}
