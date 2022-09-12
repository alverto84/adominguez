package com.adominguez.productservice.infrastructure.repository;

import com.adominguez.productservice.infrastructure.repository.entity.PriceEntity;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

  /**
   * Método busca en BDD los distintos precios y tarifas que pueden aplicarse a un determinado producto de una cadena,
   * en la fecha indicada
   *
   * @param brandId
   * @param productId
   * @param aplicationDate
   * @return Price
   */
  @Query("SELECT p FROM PriceEntity p "
      + "WHERE p.brand.brandId = :brandId "
      + "AND p.product.productId = :productId "
      + "AND :aplicationDate BETWEEN p.startDate AND p.endDate")
  PriceEntity findPriceByFilters(Integer brandId, Integer productId, LocalDateTime aplicationDate);

}
