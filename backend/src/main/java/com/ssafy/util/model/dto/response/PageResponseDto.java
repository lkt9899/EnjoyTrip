package com.ssafy.util.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageResponseDto<T> {
  private List<T> list;
  private int currentPageNum;
  private int totalPageCount;
}
