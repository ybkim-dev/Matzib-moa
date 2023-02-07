package com.project.matzibmoa.domain.store.dto.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.matzibmoa.domain.store.domain.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class KakaoRestaurantSearchDocumentsResponseDto {
    private String id;                  // 장소 ID
    @JsonProperty("place_name")
    private String placeName;           // 장소명, 업체명
    @JsonProperty("category_name")
    private String categoryName;        // 카테고리 이름
    @JsonProperty("category_group_code")
    private String categoryGroupCode;   // 중요 카테고리만 그룹핑한 카테고리 그룹 코드
    @JsonProperty("category_group_name")
    private String categoryGroupName;   // 중요 카테고리만 그룹핑한 카테고리 그룹명
    private String phone;               // 전화번호
    @JsonProperty("address_name")
    private String addressName;         // 전체 지번 주소
    @JsonProperty("road_address_name")
    private String roadAddressName;     // 전체 도로명 주소
    private String x;                   // X 좌표값, 경위도인 경우 longitude (경도)
    private String y;                   // Y 좌표값, 경위도인 경우 latitude(위도)
    @JsonProperty("place_url")
    private String placeUrl;            // 장소 상세페이지 URL
    private String distance;            // 중심좌표까지의 거리 (단, x,y 파라미터를 준 경우에만 존재) 단위 meter

    public Store toStore() {
        return Store.builder()
            .kakaoStoreId(Long.parseLong(id))
            .address(addressName)
            .longitude(Double.parseDouble(x))
            .latitude(Double.parseDouble(y))
            .name(placeName)
            .build();
    }
}
