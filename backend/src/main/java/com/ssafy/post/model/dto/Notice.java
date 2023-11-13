package com.ssafy.post.model.dto;

import com.ssafy.global.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Notice extends BaseTimeEntity {
    private int noticeId;
    private int memberId;
    private String title;
    private String content;
    private int hit;
}
