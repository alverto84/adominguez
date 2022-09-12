package com.adominguez.productservice.domain.price.service;

import com.adominguez.productservice.domain.exception.IncorrectBrandIdException;
import com.adominguez.productservice.domain.exception.IncorrectProductIdException;
import com.adominguez.productservice.domain.exception.PriceNotFoundException;
import com.adominguez.productservice.domain.in_ports.PriceService;
import com.adominguez.productservice.domain.out_ports.BrandPersistence;
import com.adominguez.productservice.domain.out_ports.PricePersistence;
import com.adominguez.productservice.domain.out_ports.ProductPersistence;
import com.adominguez.productservice.domain.price.model.Price;
import com.adominguez.productservice.infrastructure.adapters.rest.dto.PriceDTO;
import com.adominguez.productservice.infrastructure.mapper.PriceMapper;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

  private PricePersistence pricePersistence;
  private BrandPersistence brandPersistence;
  private ProductPersistence productPersistence;
  private PriceMapper priceMapper;

  private static final String PRICE_NOT_FOUND_MSG = "No se ha el precio final para el producto con Id %s, en la fecha indicada";

  @Override
  public PriceDTO getPrice(Integer brandId, Integer productId, LocalDateTime aplicationDate)
      throws IncorrectBrandIdException, IncorrectProductIdException, PriceNotFoundException {

    this.validateFields(brandId, productId);
    Price price = this.pricePersistence.findPriceByFilters(brandId, productId, aplicationDate);
    if (Objects.isNull(price)) {
      throw new PriceNotFoundException(String.format(PRICE_NOT_FOUND_MSG, productId));
    }
    return priceMapper.priceModelToDto(price);
  }

  private void validateFields(Integer brandId, Integer productId)
      throws IncorrectBrandIdException, IncorrectProductIdException {
    this.brandPersistence.validateBrandId(brandId);
    this.productPersistence.validateProductId(productId);
  }

  /**
   * Método que busca la tarifa que tiene más prioridad
   *
   * @param priceList
   * @return PriceDTO

  private PriceDTO getPriceMaxPriority(List<Price> priceList) {
  Price price = Collections.max(priceList, new Comparator<Price>() {
  public int compare(Price price1, Price price2) {
  return Integer.compare(price1.getPriority(), price2.getPriority());
  }
  });
  return this.priceMapper.priceToPriceDto(price, price.getBrand().getBrandId(), price.getProduct().getProductId());
  }
   */
}
