package com.ssafy.attraction.controller;

import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.attraction.model.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/attraction")
public class AttractionController {

    private final AttractionService attractionService;
    @GetMapping("/list")
   public ResponseEntity<?> list(){
       try {
          List<Attraction> list = attractionService.selectAll();
          return ResponseEntity.status(HttpStatus.OK).body(list);
       } catch (SQLException e) {
          return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

       }

    }
}
