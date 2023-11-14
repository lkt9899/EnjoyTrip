package com.ssafy.post.controller;

import com.ssafy.post.model.dto.Post;
import com.ssafy.post.model.dto.data.PostRequest;
import com.ssafy.post.model.service.PostService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
@Api("post controller")
public class PostController {

    private final PostService postService;

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody Post post) throws SQLException {
        postService.insert(post);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Post>> list(@RequestParam Map<String, Object> map) throws SQLException {
        log.info("post - list count :{} ", map.get("count"));
        log.info("post - list offset :{} ", map.get("offset"));

        List<Post> list = postService.selectAll(map);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/view/{postId}")
    public ResponseEntity<Post> view(@PathVariable("postId") int postId) throws SQLException {
        Post post = postService.select(postId);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<String> update(@PathVariable int postId, @RequestBody Post post) throws SQLException {
        postService.update(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> delete(@PathVariable int postId) throws SQLException {
        postService.delete(postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
