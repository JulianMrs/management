package com.inditex.ecommerce.management.domain.ports;

import com.inditex.ecommerce.management.domain.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

}
