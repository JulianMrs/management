package com.inditex.ecommerce.management.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BRAND")
@Getter
@Setter
public class BrandEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BRAND_ID", nullable = false)
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
  private List<PriceEntity> prices = new ArrayList<>();

}
