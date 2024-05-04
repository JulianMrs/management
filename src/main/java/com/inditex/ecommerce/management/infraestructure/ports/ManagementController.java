package com.inditex.ecommerce.management.infraestructure.ports;

import com.inditex.ecommerce.management.infraestructure.dtos.PriceDto;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ManagementController {

  @GetMapping("/price/{productId}")
  public ResponseEntity<PriceDto> getPrice(@PathVariable Integer productId, @RequestParam Integer brandId,
      @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date);
}
