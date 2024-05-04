package com.inditex.ecommerce.management.application.adapters;

import com.inditex.ecommerce.management.domain.mappers.PriceDomainMapper;
import com.inditex.ecommerce.management.domain.models.PriceModel;
import com.inditex.ecommerce.management.domain.ports.CalculatePriceUseCase;
import com.inditex.ecommerce.management.domain.ports.PricesRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatePriceUseCaseImpl implements CalculatePriceUseCase {

  private final PricesRepository pricesRepository;

  @Autowired
  public CalculatePriceUseCaseImpl(PricesRepository pricesRepository) {
    this.pricesRepository = pricesRepository;

  }

  @Override
  public PriceModel calculateProductPrice(Integer productId, Integer brandId, LocalDateTime date) {
    var prices = PriceDomainMapper.INSTANCE.pricesEntitiesToModels(
        pricesRepository.findByProductAndDateAndBrand(productId, brandId).orElse(null));

    if (prices == null) {
      return null;
    }

    var finalPrice = prices.stream()
        .filter(price -> date.isAfter(price.getStartDate()) && date.isBefore(price.getEndDate()))
        .max(Comparator.comparingInt(PriceModel::getPriority));
    return finalPrice.orElse(null);
  }
}
