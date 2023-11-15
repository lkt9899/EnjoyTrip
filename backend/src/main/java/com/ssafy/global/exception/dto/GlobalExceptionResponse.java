package com.ssafy.global.exception.dto;

import com.ssafy.global.exception.GlobalException;
import lombok.*;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GlobalExceptionResponse {
    private String message;
    private String errorCode;

    public static ResponseEntity<GlobalExceptionResponse> toResponse(GlobalException e) {
        System.out.println(e.getStatusCode());
        System.out.println(e.getErrorCode());
        System.out.println(e.getMessage());

        return ResponseEntity
                .status(e.getStatusCode())
                .body(GlobalExceptionResponse.builder()
                        .errorCode(e.getErrorCode())
                        .message(e.getMessage())
                        .build()
                );
    }
}
