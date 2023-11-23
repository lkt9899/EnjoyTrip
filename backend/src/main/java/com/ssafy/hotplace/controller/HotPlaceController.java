package com.ssafy.hotplace.controller;

import com.ssafy.hotplace.model.dto.data.request.HotPlaceRequest;
import com.ssafy.hotplace.model.dto.data.response.HotPlaceResponse;
import com.ssafy.hotplace.model.service.HotPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/hotplace")
@RequiredArgsConstructor
public class HotPlaceController {
    private final HotPlaceService hotPlaceService;

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody HotPlaceRequest req) {
        try {
            hotPlaceService.insert(req);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/update/{hotPlaceId}")
    public ResponseEntity<Void> update(@RequestBody HotPlaceRequest req, @PathVariable int hotPlaceId) {
        try {
            req.setHotPlaceId(hotPlaceId);
            hotPlaceService.update(req);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/view/{hotPlaceId}")
    public ResponseEntity<HotPlaceResponse> select(@PathVariable int hotPlaceId) {
        try {
            HotPlaceResponse res = hotPlaceService.select(hotPlaceId);
            if (res != null) {
                return ResponseEntity.status(HttpStatus.OK).body(res);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/list/{sidoCode}")
    public ResponseEntity<List<HotPlaceResponse>> list(@PathVariable int sidoCode) {
        return ResponseEntity.status(HttpStatus.OK).body(hotPlaceService.listBySido(sidoCode));
    }
}
