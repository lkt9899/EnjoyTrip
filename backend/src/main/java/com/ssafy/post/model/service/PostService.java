package com.ssafy.post.model.service;

import com.ssafy.post.model.dao.PostRepository;
import com.ssafy.post.model.dto.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository mapper;

    @Transactional
    public void insert(Post post) throws SQLException {
        mapper.insert(post);
    }

    public List<Post> selectAll() throws SQLException{
        return mapper.selectAll();
    }

    public Post select(int postId) throws SQLException{
        return mapper.select(postId);
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
