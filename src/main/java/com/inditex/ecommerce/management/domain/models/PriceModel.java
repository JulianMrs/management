package com.inditex.ecommerce.management.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceModel {

  private Integer id;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Integer priority;

  private BigDecimal price;

  private String iso;

  private Integer priceList;

  private Integer productId;

  private Integer brandId;
}
