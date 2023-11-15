package com.ssafy.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagingInfo {
  private int offset;
  private int count;
}
