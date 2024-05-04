package com.inditex.ecommerce.management.application.mappers;

import com.inditex.ecommerce.management.domain.models.PriceModel;
import com.inditex.ecommerce.management.infraestructure.dtos.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceDtoMapper {

  PriceDtoMapper INSTANCE = Mappers.getMapper(PriceDtoMapper.class);

  @Mapping(target = "id", source = "id", ignore = true)
  @Mapping(target = "priority", source = "priority", ignore = true)
  @Mapping(target = "iso", source = "iso", ignore = true)
  PriceDto priceModelToDto(PriceModel priceModel);

}
