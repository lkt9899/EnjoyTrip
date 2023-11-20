package com.ssafy.post.model.dao;

import com.ssafy.post.model.dto.Post;
import com.ssafy.util.dto.PageRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PostRepository {
    // 게시글 작성
    void insert(Post post) throws SQLException;
    //게시글 목록
    List<Post> getPostsPerPage(PageRequestDto pageRequestDto) throws SQLException;
    // 전체 게시글 수 조회
    int getTotalPostCount() throws SQLException;
    // 게시글 상세 조회
    Post select(int postId) throws SQLException;
    void updateHit(int postId) throws  SQLException;
    //게시글 수정
    void update(Post post) throws SQLException;
    // 게시글 삭제
    void delete(int postId) throws SQLException;

}
