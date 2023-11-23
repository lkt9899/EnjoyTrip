package com.ssafy.util.model.dto.request;

import com.ssafy.util.model.dto.PagingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MainQueryParams {
//  private RequestPosition requestPosition;
  private String lng;
  private String lat;
  private PagingInfo pagingInfo;
}
