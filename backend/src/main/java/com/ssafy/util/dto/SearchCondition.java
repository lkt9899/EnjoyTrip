package com.ssafy.util.dto;

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
