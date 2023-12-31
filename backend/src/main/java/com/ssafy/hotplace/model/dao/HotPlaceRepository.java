package com.ssafy.hotplace.model.dao;

import com.ssafy.hotplace.model.dto.data.common.HotPlace;
import com.ssafy.hotplace.model.dto.data.request.HotPlaceRequest;
import com.ssafy.hotplace.model.dto.data.response.HotPlaceResponse;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface HotPlaceRepository {
    void insert(HotPlaceRequest req) throws SQLException;
    void update(HotPlace hotplace) throws SQLException;
    HotPlaceResponse select(int hotPlaceId) throws SQLException;
    List<HotPlaceResponse> listBySido(int sidoCode);

    void updateHit(int hotPlaceId) throws SQLException;
}
