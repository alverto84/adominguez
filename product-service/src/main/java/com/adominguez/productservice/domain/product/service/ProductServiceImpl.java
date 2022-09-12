package com.adominguez.productservice.domain.product.service;

import com.adominguez.productservice.domain.exception.IncorrectProductIdException;
import com.adominguez.productservice.domain.in_ports.ProductService;
import com.adominguez.productservice.domain.out_ports.ProductPersistence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  ProductPersistence productPersistence;

  @Override
  public void validateProductId(Integer productId) throws IncorrectProductIdException {
    productPersistence.validateProductId(productId);
  }

}
