package com.adominguez.productservice.infrastructure.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "IN_PRICE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PRICE_ID")
  private Integer priceId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BRAND_ID")
  private BrandEntity brand;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "START_DATE")
  private LocalDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "END_DATE")
  private LocalDateTime endDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRICE_LIST")
  private PriceListEntity priceListEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private ProductEntity product;

  @Column(name = "PRIORITY")
  private Integer priority;

  @Column(name = "PRICE")
  private Double price;

  @Column(name = "CURRENCY")
  private String currency;
}
