package com.ssafy.post.model.service;

import com.ssafy.post.model.dao.PostRepository;
import com.ssafy.post.model.dto.Post;
import com.ssafy.util.dto.PagingInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository mapper;

    @Transactional
    public void insert(Post post) throws SQLException {
        mapper.insert(post);
    }

    public List<Post> selectAll(PagingInfo pagingInfo) throws SQLException{
        return mapper.selectAll(pagingInfo);
    }

    @Transactional
    public Post select(int postId) throws SQLException{
        mapper.updateHit(postId);
        return mapper.select(postId);
    }

    public int selectCountOfPost() throws SQLException {
        return mapper.selectCountOfPost();
    }

    @Transactional
    public void update(Post post) throws SQLException{
        mapper.update(post);
    }

    @Transactional
    public void delete(int postId) throws SQLException{
        mapper.delete(postId);
    }
}
