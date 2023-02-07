package com.project.matzibmoa.domain.store.dto.kakao;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@Getter
public class KakaoRestaurantSearchRequestDto {
    @NotBlank
    private final String query;                      // 검색어
    private final Double x;                     // 검색 x 좌표
    private final Double y;                     // 검색 y 좌표
    @Builder.Default private Integer radius = 500;                   // 검색 반경 (m)
    @Builder.Default private Integer page = 1;                          // 검색 페이지
    @Builder.Default private Integer size = 10;                          // 한 페이지 내의 결과 갯수
    @Builder.Default private String sort = "accuracy";     // 정렬 방법

    @Builder
    public KakaoRestaurantSearchRequestDto(String query, Double x, Double y) {
        this.query = query;
        this.x = x;
        this.y = y;
        this.radius = 500;
        this.page = 1;
        this.size = 10;
    }

    public MultiValueMap<String, String> toParamMap() {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("query", query);
        map.add("x", String.valueOf(x));
        map.add("y", String.valueOf(y));
        map.add("radius", String.valueOf(radius));
        map.add("page", String.valueOf(page));
        map.add("size", String.valueOf(size));
        map.add("sort", sort);
        return map;
    }
}
