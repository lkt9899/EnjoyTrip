package com.ssafy.post.exception;

import com.ssafy.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum PostErrorCode implements ErrorCode {
    NOT_EXIST_POST(204, "POST_01", "존재하지 않는 게시물입니다."),
    NO_AUTHORITY_OF_POST(401, "POST_02", "로그인 후 이용 가능합니다."),
    NOT_AUTHOR(401, "POST_03", "작성자만 접근 가능합니다.");

    private int statusCode;
    private String errorCode;
    private String message;

    PostErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
