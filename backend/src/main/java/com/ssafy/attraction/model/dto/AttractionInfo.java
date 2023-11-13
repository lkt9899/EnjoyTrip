package com.ssafy.attraction.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AttractionInfo{
   String contentId;
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
