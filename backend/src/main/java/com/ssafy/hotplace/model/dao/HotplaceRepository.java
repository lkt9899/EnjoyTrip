package com.ssafy.hotplace.model.dao;

import com.ssafy.hotplace.model.dto.Hotplace;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface HotplaceRepository {
    void insert(Hotplace hotplace) throws SQLException;
    void update(Hotplace hotplace) throws SQLException;
}
