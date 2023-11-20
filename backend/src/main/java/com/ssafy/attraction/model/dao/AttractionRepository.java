package com.ssafy.attraction.model.dao;

import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.util.dto.QueryParams;
import com.ssafy.util.dto.SearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionRepository {

   List<Attraction> select(SearchCondition condition) throws SQLException;
   int selectCountOfAttraction() throws SQLException;


   List<Attraction> selectByScroll(QueryParams params) throws SQLException;


}
