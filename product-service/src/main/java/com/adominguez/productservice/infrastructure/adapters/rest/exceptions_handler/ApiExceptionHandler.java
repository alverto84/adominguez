package com.adominguez.productservice.infrastructure.adapters.rest.exceptions_handler;

import com.adominguez.productservice.infrastructure.adapters.rest.dto.ErrorDTO;
import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;
import com.adominguez.productservice.domain.exception.IncorrectProductIdException;
import com.adominguez.productservice.domain.exception.PriceNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IncorrectBrandIdException.class)
  public ResponseEntity<ErrorDTO> springHandleIncorrectBrand(Exception ex, WebRequest request) throws IOException {
    return this.getNotFoundError(ex, request);
  }

  @ExceptionHandler(IncorrectProductIdException.class)
  public ResponseEntity<ErrorDTO> springHandleIncorrectProduct(Exception ex, WebRequest request) throws IOException {
    return this.getNotFoundError(ex, request);
  }

  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<ErrorDTO> springHandlePriceNotFound(Exception ex, WebRequest request) throws IOException {
    return this.getNotFoundError(ex, request);
  }

  private ResponseEntity<ErrorDTO> getNotFoundError(Exception ex, WebRequest request) throws IOException {
    ErrorDTO errorDto = ErrorDTO.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NO_CONTENT.value())
        .error(ex.getMessage()).build();
    return new ResponseEntity<>(errorDto, HttpStatus.NO_CONTENT);
  }

}
