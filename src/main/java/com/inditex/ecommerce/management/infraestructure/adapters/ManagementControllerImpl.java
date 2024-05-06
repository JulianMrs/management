package com.inditex.ecommerce.management.infraestructure.adapters;

import com.inditex.ecommerce.management.application.mappers.PriceDtoMapper;
import com.inditex.ecommerce.management.domain.ports.CalculatePriceUseCase;
import com.inditex.ecommerce.management.infraestructure.dtos.PriceDto;
import com.inditex.ecommerce.management.infraestructure.ports.ManagementController;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class ManagementControllerImpl implements ManagementController {

  private final CalculatePriceUseCase calculatePriceUseCase;

  @Override
  public ResponseEntity<PriceDto> getPrice(Long productId, Long brandId, LocalDateTime applicationDate) {

    if (!calculatePriceUseCase.existsProducIdAndBrandId(productId, brandId)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "El producto con id '" + productId + "' perteneciente al grupo: '" + brandId + "' no existe.");
    }

    return ResponseEntity.ok(
        PriceDtoMapper.INSTANCE.priceModelToDto(calculatePriceUseCase.calculateProductPrice(productId, brandId, applicationDate)));
  }

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
    return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
  }
}
