package com.ssafy.attraction.controller;

import com.fasterxml.jackson.core.JsonToken;
import com.ssafy.attraction.model.dto.AttractionInfo;
import com.ssafy.attraction.model.service.AttractionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RequiredArgsConstructor
@RestController
@RequestMapping("/attraction")
public class AttractionController {

    private final AttractionService attractionService;
    @ApiOperation(value = "관광지 목록")
    @GetMapping("/list")
   public ResponseEntity<?> list(){
       try {
          List<AttractionInfo> list = attractionService.selectAll();
         HttpHeaders header = new HttpHeaders();
         header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
          return ResponseEntity.status(HttpStatus.OK).headers(header).body(list);
       } catch (SQLException e) {
          return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

       }

    }
}
