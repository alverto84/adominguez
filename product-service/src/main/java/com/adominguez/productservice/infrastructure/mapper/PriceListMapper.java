package com.adominguez.productservice.infrastructure.mapper;

import com.adominguez.productservice.domain.price.model.PriceList;
import com.adominguez.productservice.infrastructure.adapters.rest.dto.PriceListDTO;

public interface PriceListMapper {

  PriceListDTO priceListToPriceListDto(PriceList priceList);
}
