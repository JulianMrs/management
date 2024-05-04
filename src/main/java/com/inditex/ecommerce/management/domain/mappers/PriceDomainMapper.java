package com.inditex.ecommerce.management.domain.mappers;

import com.inditex.ecommerce.management.domain.entities.PriceEntity;
import com.inditex.ecommerce.management.domain.models.PriceModel;
import java.util.ArrayList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceDomainMapper {

  PriceDomainMapper INSTANCE = Mappers.getMapper(PriceDomainMapper.class);

  ArrayList<PriceModel> pricesEntitiesToModels(ArrayList<PriceEntity> priceEntities);

  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "brand.id", target = "brandId")
  PriceModel priceEntityToModel(PriceEntity priceEntity);
}
