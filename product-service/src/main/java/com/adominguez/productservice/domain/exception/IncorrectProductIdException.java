package com.adominguez.productservice.domain.exception;

import java.io.Serializable;

public class IncorrectProductIdException extends Exception implements Serializable {

  private static final long serialVersionUID = 1L;

  public IncorrectProductIdException(String errorMessage) {
    super(errorMessage);
  }

}
