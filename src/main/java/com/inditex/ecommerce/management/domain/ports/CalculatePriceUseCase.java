package com.inditex.ecommerce.management.domain.ports;

import com.inditex.ecommerce.management.domain.models.PriceModel;
import java.time.LocalDateTime;

public interface CalculatePriceUseCase {

  PriceModel calculateProductPrice(Long productId, Long brandId, LocalDateTime applicationDate);

  boolean existsProducIdAndBrandId(Long productId, Long brandId);
}
