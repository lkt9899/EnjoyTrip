package com.ssafy.util.controller;

import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.post.model.service.PostService;
import com.ssafy.util.model.dto.Statistics;
import com.ssafy.util.model.service.UtilService;
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
    private final UtilService utilService;

    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getStatistics(){
        Statistics statistics = utilService.getCount();
        return ResponseEntity.status(HttpStatus.OK).body(statistics);
    }
}
