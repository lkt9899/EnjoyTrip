package com.ssafy.post.model.service;

import com.ssafy.post.exception.PostErrorCode;
import com.ssafy.post.exception.PostException;
import com.ssafy.post.model.dao.PostRepository;
import com.ssafy.post.model.dto.Post;
import com.ssafy.post.model.dto.response.PostResponse;
import com.ssafy.util.model.dto.request.PageRequestDto;
import com.ssafy.util.model.dto.response.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository mapper;

    @Transactional
    public void insert(Post post)  {
        mapper.insert(post);
    }

    public PageResponseDto<PostResponse> getPostsPerPage(PageRequestDto pageRequestDto) {
        List<PostResponse> list = mapper.getPostsPerPage(pageRequestDto);
        boolean hasNext = true;
        boolean hasPrev = false;

        Integer lastPostId = mapper.getFirstPostId();
        Integer firstPostId = mapper.getLastPostId();

        if (pageRequestDto.getLastItemId() != -1){
            hasNext = list.get(list.size() - 1).getPostId() != lastPostId;
            hasPrev = true;
        }

        if(pageRequestDto.getFirstItemId() != -1){
            hasPrev = list.get(0).getPostId() != firstPostId;
            hasNext = true;
        }

        return PageResponseDto.<PostResponse>builder()
                .list(list)
                .hasNext(hasNext)
                .hasPrev(hasPrev)
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
