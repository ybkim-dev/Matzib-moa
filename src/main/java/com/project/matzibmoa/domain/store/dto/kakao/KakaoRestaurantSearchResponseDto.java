package com.project.matzibmoa.domain.store.dto.kakao;

import com.project.matzibmoa.domain.store.domain.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class KakaoRestaurantSearchResponseDto {
    private KakaoRestaurantSearchMetaResponseDto meta;
    private List<KakaoRestaurantSearchDocumentsResponseDto> documents;
}
