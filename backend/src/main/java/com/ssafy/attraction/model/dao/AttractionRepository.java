package com.ssafy.attraction.model.dao;

import com.ssafy.attraction.model.dto.AttractionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionRepository {

   List<AttractionInfo> selectAll();

}
