package com.adominguez.productservice.domain.out_ports;

import com.adominguez.productservice.domain.exception.IncorrectProductIdException;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPersistence {

  void validateProductId(Integer productId) throws IncorrectProductIdException;
}
