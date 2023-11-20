package com.ssafy.attraction.model.dao;

import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.attraction.model.dto.QueryParams;
import com.ssafy.attraction.model.dto.SearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionRepository {

   List<Attraction> select(SearchCondition condition) throws SQLException;

   List<Attraction> selectByScroll(QueryParams params) throws SQLException;


}
