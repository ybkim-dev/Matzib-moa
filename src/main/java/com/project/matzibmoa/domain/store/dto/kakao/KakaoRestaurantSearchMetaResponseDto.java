package com.project.matzibmoa.domain.store.dto.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class KakaoRestaurantSearchMetaResponseDto {
    private int totalCnt;
    private int pageableCnt;
    private boolean isEnd;
}
