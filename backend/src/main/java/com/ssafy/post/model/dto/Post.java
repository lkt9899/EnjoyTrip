package com.ssafy.post.model.dto;

import com.ssafy.global.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Post extends BaseTimeEntity {
    private int postId;
    private int authorId;
    private String title;
    private String content;
    private int hit;
}
