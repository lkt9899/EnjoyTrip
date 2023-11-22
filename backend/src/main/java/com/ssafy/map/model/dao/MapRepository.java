package com.ssafy.map.model.dao;

import com.ssafy.map.model.dto.LocationCodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapRepository {
    List<LocationCodeDto> getSido();
    List<LocationCodeDto> getGugunInSido(String sidoCode);
    List<LocationCodeDto> getContentType();
}
