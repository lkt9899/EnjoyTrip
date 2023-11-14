package com.ssafy.hotplace.model.service;

import com.ssafy.hotplace.model.dto.HotPlace;

import java.sql.SQLException;


public interface HotPlaceService {
    void insert(HotPlace hotplace) throws SQLException;
    void update(HotPlace hotplace) throws SQLException;
}
