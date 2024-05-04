package com.inditex.ecommerce.management.domain.ports;

import com.inditex.ecommerce.management.domain.entities.PriceEntity;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {

  @Query(
      "SELECT p FROM PriceEntity p WHERE p.product.id = :productId AND p.brand.id = :brandId")
  Optional<ArrayList<PriceEntity>> findByProductAndDateAndBrand(@Param("productId") Integer productId,
      @Param("brandId") Integer brandId);
}
