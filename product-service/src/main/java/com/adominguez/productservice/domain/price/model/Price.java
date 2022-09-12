package com.adominguez.productservice.domain.price.model;

import com.adominguez.productservice.domain.brand.model.Brand;
import com.adominguez.productservice.domain.product.model.Product;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
@Builder
public class Price {

  private Integer priceId;
  private Brand brand;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private PriceList priceList;
  private Product product;
  private Integer priority;
  private Double price;
  private String currency;
}
