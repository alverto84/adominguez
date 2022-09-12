package com.adominguez.productservice.infrastructure.repository.adapter;

import com.adominguez.productservice.domain.out_ports.PricePersistence;
import com.adominguez.productservice.domain.price.model.Price;
import com.adominguez.productservice.infrastructure.mapper.PriceMapper;
import com.adominguez.productservice.infrastructure.repository.PriceRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PricePersistenceH2 implements PricePersistence {

  private PriceRepository priceRepository;
  private PriceMapper mapper;

  @Autowired
  public PricePersistenceH2(PriceRepository priceRepository, PriceMapper mapper) {
    this.priceRepository = priceRepository;
    this.mapper = mapper;
  }

  @Override
  public Price findPriceByFilters(Integer brandId, Integer productId, LocalDateTime aplicationDate) {
    return mapper.priceEntityToModel(priceRepository.findPriceByFilters(brandId, productId, aplicationDate));
  }
}
