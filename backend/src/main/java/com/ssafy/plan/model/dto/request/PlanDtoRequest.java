package com.ssafy.plan.model.dto.request;

import com.ssafy.plan.model.dto.common.PlanDetail;
import com.ssafy.plan.model.dto.common.PlanDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlanDtoRequest extends PlanDto {
    private List<PlanDetail> planDetailList;
}