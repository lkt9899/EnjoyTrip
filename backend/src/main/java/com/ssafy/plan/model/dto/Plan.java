package com.ssafy.plan.model.dto;

import com.ssafy.plan.model.dto.common.PlanDetail;
import com.ssafy.plan.model.dto.common.PlanDto;
import com.ssafy.plan.model.dto.request.PlanDtoRequest;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan extends PlanDto {
    private int planId;

    public Plan of(int planId, PlanDtoRequest planDtoRequest) {
        return Plan.builder()
                .planId(planId)
                .build();
    }
}
