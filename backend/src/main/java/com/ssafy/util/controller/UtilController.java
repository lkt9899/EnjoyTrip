package com.ssafy.util.controller;

import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.post.model.service.PostService;
import com.ssafy.util.dto.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/util")
public class UtilController {

  private final AttractionService attractionService;
  private final MemberService memberService;
  private final PostService postService;

  @GetMapping("/statistics")
  public ResponseEntity<?> getStatistics(){
    try {
      int countOfAttraction = attractionService.selectCountOfAttraction();
      int countOfMember = memberService.selectCountOfMember();
      int countOfPost = postService.selectCountOfPost();
       return ResponseEntity.status(HttpStatus.OK).body(
               new Statistics(countOfAttraction, countOfMember, countOfPost));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
