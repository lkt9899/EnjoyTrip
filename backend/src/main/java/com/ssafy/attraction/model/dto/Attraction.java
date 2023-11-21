package com.ssafy.attraction.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Attraction {
    private int contentId;
    private int contentTypeId;
    private String title;
    private String addr1;
    private String tel;
    private String firstImage;
    private int sidoCode;
    private int gugunCode;
    private double latitude;
    private double longitude;
}
