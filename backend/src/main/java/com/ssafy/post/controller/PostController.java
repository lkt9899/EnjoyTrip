package com.ssafy.post.controller;

import com.ssafy.post.model.dto.Post;
import com.ssafy.post.model.dto.data.PostRequest;
import com.ssafy.post.model.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Response;
import java.io.Console;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService ps;

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody PostRequest postRequest) throws SQLException {
        ps.insert(postRequest.toPost());
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Post>> list() throws SQLException {
        List<Post> list = ps.selectAll();
        System.out.println(list.toString());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/view/{postId}")
    public ResponseEntity<Post> view(@PathVariable("postId") int postId) throws SQLException {
        Post post = ps.select(postId);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> update(@PathVariable int postId, @RequestBody Post post) throws SQLException {
        ps.update(post);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> delete(@PathVariable int postId) throws SQLException {
        ps.delete(postId);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }


}
