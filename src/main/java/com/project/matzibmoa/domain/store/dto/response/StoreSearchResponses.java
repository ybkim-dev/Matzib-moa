package com.project.matzibmoa.domain.store.dto.response;

import java.util.List;
import lombok.Getter;

@Getter
public class StoreSearchResponses {

  private List<StoreSearchResponse> storeSearchResponses;

  private StoreSearchResponses() {}

  private StoreSearchResponses(List<StoreSearchResponse> storeSearchResponses) {
    this.storeSearchResponses = storeSearchResponses;
  }

  public static StoreSearchResponses from(List<StoreSearchResponse> storeSearchResponses) {
    return new StoreSearchResponses(storeSearchResponses);
  }
}
