package com.ssafy.attraction.exception;

import com.ssafy.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum AttractionErrorCode implements ErrorCode {
    NO_CONTENTS_WITH_CONDITION(400, "ATTRACTION_01", "조건과 일치하는 컨텐츠가 없습니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    AttractionErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
