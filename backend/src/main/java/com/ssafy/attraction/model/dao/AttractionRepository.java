package com.ssafy.attraction.model.dao;

import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.util.model.dto.QueryParams;
import com.ssafy.util.model.dto.SearchCondition;
import com.ssafy.util.model.dto.request.MainQueryParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttractionRepository {
   List<Attraction> select(SearchCondition condition);
   List<Attraction> getAttractionPerPage(QueryParams params);
   List<Attraction> getAttractionPerPageByUser(MainQueryParams params);
   int getCountOfAttraction();

}
