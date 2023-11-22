package com.ssafy.map.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LocationCodeDto {
    private String sidoCode;
    private String sidoName;
    private String gugunCode;
    private String gugunName;
    private int contentTypeId;
    private String contentTypeName;

}
