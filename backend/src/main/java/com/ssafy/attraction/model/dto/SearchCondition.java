package com.ssafy.attraction.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SearchCondition {
    private int sidoCode;
    private int gugunCode;
    private int contentTypeId;
}
