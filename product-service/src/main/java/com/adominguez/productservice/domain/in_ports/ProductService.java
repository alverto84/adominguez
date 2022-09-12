package com.adominguez.productservice.domain.in_ports;


import com.adominguez.productservice.domain.exception.IncorrectProductIdException;

public interface ProductService {

  void validateProductId(Integer productId) throws IncorrectProductIdException;

}
