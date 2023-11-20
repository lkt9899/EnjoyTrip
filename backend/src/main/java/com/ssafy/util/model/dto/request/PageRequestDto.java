package com.ssafy.util.model.dto.request;

import com.ssafy.util.model.dto.PagingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class PageRequestDto extends PagingInfo {
  private int firstItemId = -1;



}
