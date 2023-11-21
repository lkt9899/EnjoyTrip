package com.ssafy.plan.model.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PlanDto {
    protected int memberId;
    protected String title;
    protected List<PlanDetail> planDetailList;
}
