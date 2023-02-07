package com.project.matzibmoa.domain.store.application;

import com.project.matzibmoa.domain.store.domain.repository.StoreRepository;
import com.project.matzibmoa.domain.store.dto.StoreSearchResult;
import com.project.matzibmoa.domain.store.dto.kakao.KakaoRestaurantSearchRequestDto;
import com.project.matzibmoa.domain.store.dto.response.StoreSearchResponse;
import com.project.matzibmoa.domain.store.infrastructure.KakaoRestaurantSearchApiRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class StoreService {

  private final KakaoRestaurantSearchApiRepository restaurantSearchApiRepository;
  private final StoreRepository storeRepository;

  public StoreService(KakaoRestaurantSearchApiRepository restaurantSearchApiRepository,
      StoreRepository storeRepository) {
    this.restaurantSearchApiRepository = restaurantSearchApiRepository;
    this.storeRepository = storeRepository;
  }

  public List<StoreSearchResponse> search(KakaoRestaurantSearchRequestDto kakaoRestaurantSearchRequestDto) {
    List<StoreSearchResult> searchResults = storeRepository.findStoreByPointAndRange(
        kakaoRestaurantSearchRequestDto.getX(), kakaoRestaurantSearchRequestDto.getY(),
        kakaoRestaurantSearchRequestDto.getRadius());
    List<StoreSearchResponse> stores = searchResults.stream().map(StoreSearchResponse::from)
        .collect(Collectors.toList());
    return stores;
  }
}
