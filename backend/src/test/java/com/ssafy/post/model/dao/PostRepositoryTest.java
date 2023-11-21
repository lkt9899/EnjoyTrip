package com.ssafy.post.model.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

  @Autowired
  private PostRepository mapper;


  @Test
  void getLastPostId(){
    int lastPostId = mapper.getLastPostId();
    assertEquals(7, lastPostId);

  }
  @Test
  void getFirstPostId(){
    int firstPostId = mapper.getFirstPostId();
    assertEquals(2, firstPostId);

  }
}