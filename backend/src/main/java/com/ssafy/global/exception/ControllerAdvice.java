package com.ssafy.global.exception;

import com.ssafy.global.exception.dto.GlobalExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<GlobalExceptionResponse> globalHandlerException(GlobalException e) {
        return GlobalExceptionResponse.toResponse(e);
    }
}
