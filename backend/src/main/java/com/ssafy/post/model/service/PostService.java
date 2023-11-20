package com.ssafy.post.model.service;

import com.ssafy.post.model.dao.PostRepository;
import com.ssafy.post.model.dto.Post;
import com.ssafy.util.dto.PageRequestDto;
import com.ssafy.util.dto.PageResponseDto;
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

    public PageResponseDto<Post> getPostsPerPage(PageRequestDto pageRequestDto) throws SQLException{

        int pagePerCount = pageRequestDto.getCount();
        int currentPageNum = pageRequestDto.getOffset() / pagePerCount + 1;

        int totalPostCount = mapper.selectTotalCount();
        int totalPageCount = totalPostCount / pagePerCount + ((totalPostCount % pagePerCount==0)? 0 : 1);

        return PageResponseDto.<Post>builder()
                .list(mapper.getPostsPerPage(pageRequestDto))
                .currentPageNum(currentPageNum)
                .totalPageCount(totalPageCount)
                .build();
    }

    @Transactional
    public Post select(int postId) throws SQLException{

        mapper.updateHit(postId);
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
