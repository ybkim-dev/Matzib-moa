package com.project.matzibmoa.domain.store.dto;

public interface StoreSearchResult {

  Long getKakaoStoreId();
  String getName();
  Double getLongitude();
  Double getLatitude();
  String getAddress();
  String getDistance();

}
