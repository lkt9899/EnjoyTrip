package com.ssafy.post.model.dto.response;

import com.ssafy.post.model.dto.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostResponse extends Post{
  private String authorName;
}
