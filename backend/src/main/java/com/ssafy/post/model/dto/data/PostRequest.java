package com.ssafy.post.model.dto.data;

import com.ssafy.member.model.dto.Member;
import com.ssafy.post.model.dto.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRequest {
    private int authorId;
    private String title;
    private String content;

    public Post toPost() {
        return Post.builder()
                .authorId(authorId)
                .title(title)
                .content(content)
                .build();
    }
}
