package com.adominguez.productservice.infrastructure.mapper;

import com.adominguez.productservice.domain.price.model.Price;
import com.adominguez.productservice.infrastructure.adapters.rest.dto.PriceDTO;
import com.adominguez.productservice.infrastructure.repository.entity.PriceEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PriceMapper {

  PriceDTO priceModelToDto(Price price);

  Price priceEntityToModel(PriceEntity priceEntity);
}
