package com.ssafy.plan.exception;

import com.ssafy.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum PlanErrorCode implements ErrorCode {
    NOT_EXIST_PLAN(400, "PLAN_01", "존재하지 않는 여행 계획입니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    PlanErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
