package com.project.matzibmoa.domain.store.domain.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Store {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private Long kakaoStoreId;

  @Column(length = 100)
  private String name;

  private Double longitude;

  private Double latitude;

  @Column(length = 100)
  private String address;

  protected Store() {}

  protected Store(Long id, Long kakaoStoreId, String name, Double longitude, Double latitude,
      String address) {
    this.id = id;
    this.kakaoStoreId = kakaoStoreId;
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.address = address;
  }
}
