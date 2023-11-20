package com.ssafy.util.dto;

import com.ssafy.util.dto.SearchCondition;
import com.ssafy.util.dto.PagingInfo;
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
