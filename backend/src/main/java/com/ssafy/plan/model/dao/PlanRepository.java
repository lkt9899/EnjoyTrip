package com.ssafy.plan.model.dao;

import com.ssafy.plan.model.dto.Plan;
import com.ssafy.plan.model.dto.response.PlanDtoResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanRepository {
    void insert(Plan plan);
    void insertDetails(Plan plan);
    int existById(int planId);
    void delete(int planId);
    void deleteDetails(Plan plan);
    void updateName(Plan plan);
    PlanDtoResponse findPlanById(int planId);

}
