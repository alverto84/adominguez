package com.adominguez.productservice.domain.brand.service;

import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;
import com.adominguez.productservice.domain.in_ports.BrandService;
import com.adominguez.productservice.domain.out_ports.BrandPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

  BrandPersistence brandPersistence;

  @Autowired
  public BrandServiceImpl(BrandPersistence brandPersistence) {
    this.brandPersistence = brandPersistence;
  }

  @Override
  public void validateBrandId(Integer brandId) throws IncorrectBrandIdException {
    brandPersistence.validateBrandId(brandId);
  }
}
