package com.ssafy.plan.controller;

import com.ssafy.plan.model.dto.request.PlanDtoRequest;
import com.ssafy.plan.model.dto.response.PlanDtoResponse;
import com.ssafy.plan.model.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plan")
public class PlanController {
    private final PlanService planService;

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody PlanDtoRequest request) {
        planService.insert(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody PlanDtoRequest request) {
        planService.update(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/view/{planId}")
    public ResponseEntity<PlanDtoResponse> view(@PathVariable int planId) {
        PlanDtoResponse response = planService.findPlanById(planId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<Void> delete(@PathVariable int planId) {
        planService.delete(planId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
