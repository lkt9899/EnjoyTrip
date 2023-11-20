package com.ssafy.attraction.exception;

import com.ssafy.global.exception.ErrorCode;
import com.ssafy.global.exception.GlobalException;

public class AttractionException extends GlobalException {
    public AttractionException(ErrorCode errorCode) {
        super(errorCode);
    }
}
