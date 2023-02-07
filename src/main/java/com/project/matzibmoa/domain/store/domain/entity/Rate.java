package com.project.matzibmoa.domain.store.domain.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Rate {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "store_id")
  private Store store;

  private Double kakaoRate;

  private Integer kakaoRateCount;

  private Double naverRate;

  private Integer naverRateCount;

  protected Rate() {}

}
