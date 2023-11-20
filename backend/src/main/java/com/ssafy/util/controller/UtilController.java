package com.ssafy.util.controller;

import com.ssafy.util.model.dto.Statistics;
import com.ssafy.util.model.service.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
