package com.ssafy.hotplace.model.service;

import com.ssafy.hotplace.model.dao.HotPlaceRepository;
import com.ssafy.hotplace.model.dto.data.common.HotPlace;
import com.ssafy.hotplace.model.dto.data.request.HotPlaceRequest;
import com.ssafy.hotplace.model.dto.data.response.HotPlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class HotPlaceService {
    private final HotPlaceRepository mapper;

    @Transactional
    public void insert(HotPlaceRequest req) throws SQLException {
        mapper.insert(req);
    }

    @Transactional
    public void update(HotPlaceRequest req) throws SQLException {
        mapper.update(req);
    }

    @Transactional
    public HotPlaceResponse select(int hotPlaceId) throws SQLException {
        mapper.updateHit(hotPlaceId);
        return mapper.select(hotPlaceId);
    }
}
