package com.adominguez.productservice.domain.exception;

import java.io.Serializable;

public class PriceNotFoundException extends Exception implements Serializable {

  private static final long serialVersionUID = 1L;

  public PriceNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
