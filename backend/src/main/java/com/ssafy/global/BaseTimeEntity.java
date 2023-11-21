package com.ssafy.global;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class BaseTimeEntity {
    protected String regDate;
    protected String modDate;
}
