package com.ssafy.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDto {
  private int offset; //시작점
  private int count; //한 페이지당 데이터 수
}
