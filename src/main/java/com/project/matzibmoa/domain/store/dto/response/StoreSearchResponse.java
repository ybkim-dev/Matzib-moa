package com.project.matzibmoa.domain.store.dto.response;

import com.project.matzibmoa.domain.store.dto.StoreSearchResult;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StoreSearchResponse {

  private Long kakaoStoreId;
  private String name;
  private Double longitude;
  private Double latitude;
  private String address;
  private String distance;

  public static StoreSearchResponse from(StoreSearchResult storeSearchResult) {
    return StoreSearchResponse.builder()
        .kakaoStoreId(storeSearchResult.getKakaoStoreId())
        .name(storeSearchResult.getName())
        .longitude(storeSearchResult.getLongitude())
        .latitude(storeSearchResult.getLatitude())
        .address(storeSearchResult.getAddress())
        .distance(storeSearchResult.getDistance())
        .build();
  }
}
