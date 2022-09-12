package com.adominguez.productservice.domain.in_ports;

import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;
import com.adominguez.productservice.domain.exception.IncorrectProductIdException;
import com.adominguez.productservice.domain.exception.PriceNotFoundException;
import com.adominguez.productservice.infrastructure.adapters.rest.dto.PriceDTO;
import java.time.LocalDateTime;

public interface PriceService {

  PriceDTO getPrice(Integer brandId, Integer productId, LocalDateTime aplicationDate) throws IncorrectBrandIdException, IncorrectProductIdException, PriceNotFoundException;
}
