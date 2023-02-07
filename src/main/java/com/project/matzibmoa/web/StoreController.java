package com.project.matzibmoa.web;

import com.project.matzibmoa.domain.store.application.StoreService;
import com.project.matzibmoa.domain.store.dto.StoreSearchResult;
import com.project.matzibmoa.domain.store.dto.kakao.KakaoRestaurantSearchRequestDto;
import com.project.matzibmoa.domain.store.dto.response.StoreSearchResponse;
import com.project.matzibmoa.domain.store.dto.response.StoreSearchResponses;
import com.project.matzibmoa.global.ModelAttributeArgumentNotValidException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {

  private final StoreService storeService;

  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public StoreSearchResponses searchStore(
      @Valid KakaoRestaurantSearchRequestDto kakaoRestaurantSearchRequestDto, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      throw new ModelAttributeArgumentNotValidException();
    }
    List<StoreSearchResponse> searchResults = storeService.search(kakaoRestaurantSearchRequestDto);
    return StoreSearchResponses.from(searchResults);
  }

}
