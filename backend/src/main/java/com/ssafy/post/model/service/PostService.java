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

        List<PostResponse> postList = mapper.getPostsPerPage(pageRequestDto);
        int lastPostId = mapper.getLastPostId();
        int firstPostId = mapper.getFirstPostId();

        if (pageRequestDto.getLastItemId()!= -1){ //다음 페이지를 요청했다면
            return PageResponseDto.<PostResponse>builder()
                    .list(postList)
                    .hasPrev(firstPostId >= pageRequestDto.getLastItemId()?false: true)
                    .hasNext( (postList.get(postList.size()-1).getPostId() == lastPostId)? false: true)
                    .build();
        }
        if(pageRequestDto.getFirstItemId()!= -1){ //이전 페이지를 요청했다면
            return PageResponseDto.<PostResponse>builder()
                    .list(postList)
                    .hasPrev( (postList.get(0).getPostId() == firstPostId) ? false : true )
                    .hasNext(true)
                    .build();
        }
        return null;
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
