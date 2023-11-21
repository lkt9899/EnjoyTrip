package com.ssafy.plan.model.dto.response;

import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.plan.model.dto.common.PlanDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlanDtoResponse extends PlanDto {
    private List<Attraction> attractionList;
}
