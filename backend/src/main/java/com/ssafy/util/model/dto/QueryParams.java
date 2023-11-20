package com.ssafy.util.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QueryParams {
  private SearchCondition searchCondition;
  private PagingInfo pagingInfo;
}
