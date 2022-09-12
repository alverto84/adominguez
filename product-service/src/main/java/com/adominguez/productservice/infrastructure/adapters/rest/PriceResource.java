package com.adominguez.productservice.infrastructure.adapters.rest;

import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;
import com.adominguez.productservice.domain.exception.IncorrectProductIdException;
import com.adominguez.productservice.domain.exception.PriceNotFoundException;
import com.adominguez.productservice.domain.in_ports.PriceService;
import com.adominguez.productservice.infrastructure.adapters.rest.dto.PriceDTO;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PriceResource {

  PriceService priceService;

  @GetMapping("prices")
  public ResponseEntity<PriceDTO> getPrice(
      @RequestParam("brandId") Integer brandId,
      @RequestParam("productId") Integer productId,
      @RequestParam("aplicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime aplicationDate
  ) throws IncorrectBrandIdException, IncorrectProductIdException, PriceNotFoundException {

    PriceDTO priceDto = this.priceService.getPrice(brandId, productId, aplicationDate);
    return new ResponseEntity<>(priceDto, HttpStatus.OK);
  }

}
