package com.ssafy.global;

import lombok.Data;

import java.time.LocalDateTime;

//@Data
public abstract class BaseTimeEntity {
    protected LocalDateTime regDate;
    protected LocalDateTime modDate;
}
