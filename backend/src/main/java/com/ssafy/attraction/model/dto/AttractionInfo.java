package com.ssafy.attraction.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AttractionInfo {
   String title;
   String addr1;
   String addr2;
   String zipcode;
   String tel;
   String firstImage;
   String firstImage2;
   String readCount;
   String sidoCode;
   String gugunCode;
   String latitude;
   String longitude;

}
