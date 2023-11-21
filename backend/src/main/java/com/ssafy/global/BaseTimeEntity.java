package com.ssafy.global;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseTimeEntity {
    protected String regDate;
    protected String modDate;
}
