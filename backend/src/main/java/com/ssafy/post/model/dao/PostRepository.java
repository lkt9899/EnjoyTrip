package com.ssafy.post.model.dao;

import com.ssafy.post.model.dto.Post;
import com.ssafy.util.model.dto.request.PageRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {
    // 게시글 작성
    void insert(Post post);
    //게시글 목록
    List<Post> getPostsPerPage(PageRequestDto pageRequestDto);
    // 전체 게시글 수 조회
    int getTotalPostCount();
    // 게시글 상세 조회
    Post select(int postId);
    int existById(int postId);
    void updateHit(int postId);
    //게시글 수정
    void update(Post post);
    // 게시글 삭제
    void delete(int postId);

    int getLastPostId();

    int getFirstPostId();
}
