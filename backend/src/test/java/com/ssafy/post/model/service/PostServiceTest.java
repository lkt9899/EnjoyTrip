package com.ssafy.post.model.service;

import com.ssafy.post.model.dto.Post;
import com.ssafy.util.model.dto.request.PageRequestDto;
import com.ssafy.util.model.dto.response.PageResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PostServiceTest {

  @Autowired
  private PostService postService;

  @Test
  void selectAll(){
    //given
    PageRequestDto pageRequestDto = new PageRequestDto();
    pageRequestDto.setLastItemId(0);
    System.out.println(pageRequestDto.getFirstItemId());
    PageResponseDto<Post> result = null;
    try {
      result = postService.getPostsPerPage(pageRequestDto);
    } finally {
      //then
      assertNotNull(result);
      assertEquals(5, result.getList().size());
      for (Post p : result.getList()){
        System.out.println(p);
      }
      assertEquals(false, result.isHasPrev());
      assertEquals(true, result.isHasNext());
    }

  }

}