package com.ssafy.plan.exception;

import com.ssafy.global.exception.ErrorCode;
import com.ssafy.global.exception.GlobalException;

public class PlanException extends GlobalException {
    public PlanException(ErrorCode errorCode) {
        super(errorCode);
    }
}
