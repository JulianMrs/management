package com.inditex.ecommerce.management.domain.ports;

import com.inditex.ecommerce.management.domain.models.PriceModel;
import java.time.LocalDateTime;

public interface CalculatePriceUseCase {

  PriceModel calculateProductPrice(Integer productId, Integer brandId, LocalDateTime date);
}
