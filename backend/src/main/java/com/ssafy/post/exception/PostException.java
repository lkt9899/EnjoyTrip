package com.ssafy.post.exception;

import com.ssafy.global.exception.ErrorCode;
import com.ssafy.global.exception.GlobalException;

public class PostException extends GlobalException {

    public PostException(ErrorCode errorCode) {
        super(errorCode);
    }
}
