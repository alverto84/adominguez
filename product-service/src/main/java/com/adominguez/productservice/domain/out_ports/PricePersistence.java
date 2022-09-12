package com.adominguez.productservice.domain.out_ports;

import com.adominguez.productservice.domain.price.model.Price;
import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;

@Repository
public interface PricePersistence {

  Price findPriceByFilters(Integer brandId, Integer productId, LocalDateTime aplicationDate);
}
