package com.adominguez.productservice.infrastructure.repository.adapter;

import com.adominguez.productservice.domain.exception.IncorrectProductIdException;
import com.adominguez.productservice.domain.out_ports.ProductPersistence;
import com.adominguez.productservice.infrastructure.repository.ProductRepository;
import com.adominguez.productservice.infrastructure.repository.entity.ProductEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPersistenceH2 implements ProductPersistence {

  private ProductRepository productRepository;
  private static final String INCORRECT_PRODUCT_ID_MSG = "No se ha encontrado el producto con Id %s";

  @Autowired
  public ProductPersistenceH2(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void validateProductId(Integer productId) throws IncorrectProductIdException {
    Optional<ProductEntity> productOptional = this.productRepository.findById(productId);
    if (productOptional.isEmpty()) {
      throw new IncorrectProductIdException(String.format(INCORRECT_PRODUCT_ID_MSG, productId));
    }
  }
}
