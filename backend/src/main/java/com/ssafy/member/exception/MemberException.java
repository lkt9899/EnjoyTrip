package com.ssafy.member.exception;

import com.ssafy.global.exception.ErrorCode;
import com.ssafy.global.exception.GlobalException;

public class MemberException extends GlobalException {
    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
