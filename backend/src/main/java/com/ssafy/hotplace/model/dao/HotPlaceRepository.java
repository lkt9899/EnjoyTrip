package com.ssafy.hotplace.model.dao;

import com.ssafy.hotplace.model.dto.HotPlace;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface HotPlaceRepository {
    void insert(HotPlace hotplace) throws SQLException;
    void update(HotPlace hotplace) throws SQLException;
}
