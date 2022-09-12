package com.adominguez.productservice.domain.exception;

import java.io.Serializable;

public class IncorrectBrandIdException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	public IncorrectBrandIdException(String errorMessage) {
        super(errorMessage);
    }

}
