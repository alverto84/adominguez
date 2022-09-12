package com.adominguez.productservice.infrastructure.repository;

import com.adominguez.productservice.infrastructure.repository.entity.PriceEntity;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

  String PRICE_IN_ACTUAL_DATE = "FROM PriceEntity price, ProductEntity p,  BrandEntity b "
      + "JOIN ProductEntity "
      + "ON price.product = p.productId "
      + "JOIN BrandEntity "
      + "ON price.brand = b.brandId "
      + "WHERE price.startDate < :aplicationDate "
      + "AND price.endDate > :aplicationDate "
      + "AND p.productId = :productId "
      + "AND b.brandId = :brandId ";

  @Query("SELECT price "
      + PRICE_IN_ACTUAL_DATE
      + "AND price.priority IN ("
      + "SELECT MAX(price.priority)"
      + PRICE_IN_ACTUAL_DATE
      + ")"
  )
  PriceEntity findPriceByFilters(Integer brandId, Integer productId, LocalDateTime aplicationDate);

}
