package com.ssafy.plan.model.dto;

import com.ssafy.plan.model.dto.common.PlanDetail;
import com.ssafy.plan.model.dto.common.PlanDto;
import com.ssafy.plan.model.dto.request.PlanDtoRequest;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Plan extends PlanDto {
    private List<PlanDetail> planDetailList;

    private Plan(PlanDtoRequest planDtoRequest) {
        this.planId = planDtoRequest.getPlanId();
        this.memberId = planDtoRequest.getMemberId();
        this.title = planDtoRequest.getTitle();
        this.planDetailList = planDtoRequest.getPlanDetailList();
    }
    public static Plan of(PlanDtoRequest planDtoRequest) {
        return new Plan(planDtoRequest);
    }
}
