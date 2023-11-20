package com.ssafy.util.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagingInfo {
    private int offset;
    private static final int COUNT = 5;
}
