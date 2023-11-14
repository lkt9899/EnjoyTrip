package com.ssafy.post.model.dao;

import com.ssafy.post.model.dto.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface PostRepository {
    // 게시글 작성
    void insert(Post post) throws SQLException;
    //게시글 목록
    List<Post> selectAll(Map<String, Object> map) throws SQLException;
    // 게시글 상세 조회
    Post select(int postId) throws SQLException;
    void updateHit(int postId) throws  SQLException;
    //게시글 수정
    void update(Post post) throws SQLException;
    // 게시글 삭제
    void delete(int postId) throws SQLException;
}
