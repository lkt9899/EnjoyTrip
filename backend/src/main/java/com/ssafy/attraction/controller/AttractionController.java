package com.ssafy.attraction.controller;

import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.util.model.dto.QueryParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/attraction")
public class AttractionController {

    private final AttractionService attractionService;
    @PostMapping("/list")
    public ResponseEntity<List<Attraction>> list(@RequestBody QueryParams params){
        List<Attraction> list = attractionService.select(params);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
