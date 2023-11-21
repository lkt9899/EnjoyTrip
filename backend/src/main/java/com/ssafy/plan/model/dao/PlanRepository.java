package com.ssafy.plan.model.dao;

import com.ssafy.plan.model.dto.request.PlanDtoRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanRepository {
    void insert(PlanDtoRequest planRequest);
    void update(PlanDtoRequest planRequest);

}
