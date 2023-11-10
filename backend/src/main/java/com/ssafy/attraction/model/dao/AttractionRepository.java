package com.ssafy.attraction.model.dao;

import com.ssafy.attraction.model.dto.Attraction;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionRepository {

   List<Attraction> selectAll() throws SQLException;

}
