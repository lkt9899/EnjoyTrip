package com.ssafy.attraction.model.dto;

import com.ssafy.attraction.model.dto.SearchCondition;
import com.ssafy.util.dto.PagingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QueryParams {
  SearchCondition searchCondition;
  PagingInfo pagingInfo;
}
