package com.ssafy.plan.model.service;

import com.ssafy.plan.exception.PlanErrorCode;
import com.ssafy.plan.exception.PlanException;
import com.ssafy.plan.model.dao.PlanRepository;
import com.ssafy.plan.model.dto.Plan;
import com.ssafy.plan.model.dto.request.PlanDtoRequest;
import com.ssafy.plan.model.dto.response.PlanDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PlanService {
    private final PlanRepository mapper;

    @Transactional
    public void insert(PlanDtoRequest planDtoRequest) {
        Plan plan = Plan.of(planDtoRequest);
        mapper.insert(plan);
        mapper.insertDetails(plan);
    }

    @Transactional
    public void update(PlanDtoRequest planDtoRequest) {
        if(mapper.existById(planDtoRequest.getPlanId()) == 0)
            throw new PlanException(PlanErrorCode.NOT_EXIST_PLAN);

        Plan plan = Plan.of(planDtoRequest);
        mapper.deleteDetails(plan);
        mapper.updateName(plan);
        mapper.insertDetails(Plan.of(planDtoRequest));
    }

    @Transactional
    public void delete(int planId) {
        if(mapper.existById(planId) == 0)
            throw new PlanException(PlanErrorCode.NOT_EXIST_PLAN);

        mapper.delete(planId);
    }

    public PlanDtoResponse findPlanById(int planId) {
        if(mapper.existById(planId) == 0)
            throw new PlanException(PlanErrorCode.NOT_EXIST_PLAN);

        return mapper.findPlanById(planId);
    }

    public List<PlanDtoResponse> getPlanList(int memberId) {
        return mapper.getPlanList(memberId);
    }
}
