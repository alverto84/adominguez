package com.adominguez.productservice.domain.out_ports;

import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandPersistence {

  void validateBrandId(Integer brandId) throws IncorrectBrandIdException;

}
