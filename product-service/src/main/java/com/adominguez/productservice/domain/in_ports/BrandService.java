package com.adominguez.productservice.domain.in_ports;


import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;

public interface BrandService {

  void validateBrandId(Integer brandId) throws IncorrectBrandIdException;
}
