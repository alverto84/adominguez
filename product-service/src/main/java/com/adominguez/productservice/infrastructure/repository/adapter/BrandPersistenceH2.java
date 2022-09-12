package com.adominguez.productservice.infrastructure.repository.adapter;

import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;
import com.adominguez.productservice.domain.out_ports.BrandPersistence;
import com.adominguez.productservice.infrastructure.repository.BrandRepository;
import com.adominguez.productservice.infrastructure.repository.entity.BrandEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandPersistenceH2 implements BrandPersistence {

  private BrandRepository brandRepository;
  private static final String INCORRECT_BRAND_ID_MSG = "No se ha encontrado la cadena con Id %s";

  @Autowired
  public BrandPersistenceH2(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  @Override
  public void validateBrandId(Integer brandId) throws IncorrectBrandIdException {
    Optional<BrandEntity> brandOptional = this.brandRepository.findById(brandId);
    if (brandOptional.isEmpty()) {
      throw new IncorrectBrandIdException(String.format(INCORRECT_BRAND_ID_MSG, brandId));
    }
  }
}
