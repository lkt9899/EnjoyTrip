package com.ssafy.plan.model.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class PlanDto {
    protected int planId;
    protected int memberId;
    protected String title;
}
