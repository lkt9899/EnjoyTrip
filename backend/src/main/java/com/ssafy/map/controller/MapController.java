package com.ssafy.map.controller;

import com.ssafy.map.model.dto.LocationCodeDto;
import com.ssafy.map.model.service.MapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/map")
public class MapController {
    private final MapService mapService;

    @GetMapping("/sido")
    public ResponseEntity<List<LocationCodeDto>> sido() {
        log.info("sido - 호출");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapService.getSido());
    }

    @GetMapping("/gugun")
    public ResponseEntity<List<LocationCodeDto>> gugun(@RequestParam("sidoCode") String sidoCode) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapService.getGugunInSido(sidoCode));
    }

    @GetMapping("/content")
    public ResponseEntity<List<LocationCodeDto>> content() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapService.getContentType());
    }
}
