package com.ssafy.post.model.service;

import com.ssafy.post.exception.PostErrorCode;
import com.ssafy.post.exception.PostException;
import com.ssafy.post.model.dao.PostRepository;
import com.ssafy.post.model.dto.Post;
import com.ssafy.util.model.dto.request.PageRequestDto;
import com.ssafy.util.model.dto.response.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository mapper;

    @Transactional
    public void insert(Post post)  {
        mapper.insert(post);
    }

    public PageResponseDto<Post> getPostsPerPage(PageRequestDto pageRequestDto) {

        int pagePerCount = pageRequestDto.getCount();
//        int currentPageNum = pageRequestDto.getOffset() / pagePerCount + 1;

        int totalPostCount = mapper.getTotalPostCount();
        int totalPageCount = totalPostCount / pagePerCount + ((totalPostCount % pagePerCount==0)? 0 : 1);

        return PageResponseDto.<Post>builder()
                .list(mapper.getPostsPerPage(pageRequestDto))
                .currentPageNum(pageRequestDto.getCurrentPageNum())
                .totalPageCount(totalPageCount)
                .build();
    }

    @Transactional
    public Post select(int postId) {
        if(mapper.existById(postId) == 0)
            throw new PostException(PostErrorCode.NOT_EXIST_POST);

        mapper.updateHit(postId);
        return mapper.select(postId);
    }

    @Transactional
    public void update(Post post) {
        if(mapper.existById(post.getPostId()) == 0)
            throw new PostException(PostErrorCode.NOT_EXIST_POST);

        mapper.update(post);
    }

    @Transactional
    public void delete(int postId) {
        if(mapper.existById(postId) == 0)
            throw new PostException(PostErrorCode.NOT_EXIST_POST);
        mapper.delete(postId);
    }
}
