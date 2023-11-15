package com.ssafy.member.exception;

import com.ssafy.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    ID_ALREADY_EXISTS(400, "MEMBER_01", "존재하는 아이디입니다."),
    PASSWORD_IS_NOT_VALID(400, "MEMBER_02", "유효하지 않은 비밀번호 형식입니다."),
    PHONE_NUMBER_IS_NOT_VALID(400, "MEMBER_03", "유효하지 않은 전화번호 형식입니다."),

    LOGIN_FAILED(400, "MEMBER_04", "아이디가 존재하지 않거나 잘못된 비밀 번호 입니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
