package com.project.matzibmoa.domain.repository;

import com.project.matzibmoa.domain.store.dto.kakao.KakaoRestaurantSearchRequestDto;
import com.project.matzibmoa.domain.store.dto.kakao.KakaoRestaurantSearchResponseDto;
import com.project.matzibmoa.domain.store.infrastructure.KakaoRestaurantSearchApiRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoRestaurantSearchApiRepositoryTest {

    @Autowired
    KakaoRestaurantSearchApiRepository repository;

    @Test
    void kakao_search_api_호출_테스트() throws Exception {
        //given
        KakaoRestaurantSearchResponseDto response = repository.searchRestaurant(KakaoRestaurantSearchRequestDto.builder()
                .x(127.1247734)
                .y(37.3869285)
                .query("소고기")
                .build());
        // when
        System.out.println(response);
        //then
    }

}