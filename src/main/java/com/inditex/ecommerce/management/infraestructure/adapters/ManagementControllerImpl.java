package com.inditex.ecommerce.management.infraestructure.adapters;

import com.inditex.ecommerce.management.application.mappers.PriceDtoMapper;
import com.inditex.ecommerce.management.domain.ports.CalculatePriceUseCase;
import com.inditex.ecommerce.management.infraestructure.dtos.PriceDto;
import com.inditex.ecommerce.management.infraestructure.ports.ManagementController;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ManagementControllerImpl implements ManagementController {

  private final CalculatePriceUseCase calculatePriceUseCase;

  @Autowired
  public ManagementControllerImpl(CalculatePriceUseCase calculatePriceUseCase) {
    this.calculatePriceUseCase = calculatePriceUseCase;
  }

  @Override
  public ResponseEntity<PriceDto> getPrice(Integer productId, Integer brandId, LocalDateTime date) {
    var finalPrice = PriceDtoMapper.INSTANCE.priceModelToDto(calculatePriceUseCase.calculateProductPrice(productId, brandId, date));

    if (finalPrice == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto con ID '" + productId + "' no existe.");
    }

    return ResponseEntity.ok(finalPrice);
  }

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
    return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
  }
}
