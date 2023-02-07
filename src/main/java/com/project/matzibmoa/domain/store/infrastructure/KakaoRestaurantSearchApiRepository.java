package com.project.matzibmoa.domain.store.infrastructure;

import com.project.matzibmoa.domain.store.dto.kakao.KakaoRestaurantSearchRequestDto;
import com.project.matzibmoa.domain.store.dto.kakao.KakaoRestaurantSearchResponseDto;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
@Primary
public class KakaoRestaurantSearchApiRepository {
    @Value("${config.api.kakao.search.rest-api-key}")
    private String apiKey;
    @Value("${config.api.kakao.search.url}")
    private String kakaoSearchUrl;

    public KakaoRestaurantSearchResponseDto searchRestaurant(KakaoRestaurantSearchRequestDto params) {
        URI uri = UriComponentsBuilder
                .fromUriString(kakaoSearchUrl)
                .queryParams(params.toParamMap())
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();

        // set header
        HttpEntity<Object> httpEntity = setHttpEntity();
        // set responseType
        ParameterizedTypeReference<KakaoRestaurantSearchResponseDto> responseType = new ParameterizedTypeReference<>() {};
        // send request
        ResponseEntity<KakaoRestaurantSearchResponseDto> response = requestApi(uri, httpEntity, responseType);
        return response.getBody();
    }

    private ResponseEntity<KakaoRestaurantSearchResponseDto> requestApi(URI uri, HttpEntity<Object> httpEntity, ParameterizedTypeReference<KakaoRestaurantSearchResponseDto> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<KakaoRestaurantSearchResponseDto> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return response;
    }

    private HttpEntity<Object> setHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + apiKey);
        httpHeaders.set("Content-Type", "application/json");
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        return httpEntity;
    }
}
