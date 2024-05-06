package com.inditex.ecommerce.management.application.adapters;

import com.inditex.ecommerce.management.domain.mappers.PriceDomainMapper;
import com.inditex.ecommerce.management.domain.models.PriceModel;
import com.inditex.ecommerce.management.domain.ports.BrandRepository;
import com.inditex.ecommerce.management.domain.ports.CalculatePriceUseCase;
import com.inditex.ecommerce.management.domain.ports.PricesRepository;
import com.inditex.ecommerce.management.domain.ports.ProductRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatePriceUseCaseImpl implements CalculatePriceUseCase {

  private final PricesRepository pricesRepository;

  private final ProductRepository productRepository;

  private final BrandRepository brandRepository;

  @Override
  public PriceModel calculateProductPrice(Long productId, Long brandId, LocalDateTime date) {
    var prices = PriceDomainMapper.INSTANCE.pricesEntitiesToModels(
        pricesRepository.findByProductIdAndBrandId(productId, brandId).orElse(null));

    var finalPrice = prices.stream()
        .filter(price -> date.isAfter(price.getStartDate()) && date.isBefore(price.getEndDate()))
        .max(Comparator.comparingInt(PriceModel::getPriority));
    return finalPrice.orElse(null);
  }

  @Override
  public boolean existsProducIdAndBrandId(Long productId, Long brandId) {
    return productRepository.findById(productId).isPresent() && brandRepository.findById(brandId).isPresent();
  }


}
