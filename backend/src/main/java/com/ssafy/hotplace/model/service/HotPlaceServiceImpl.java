package com.ssafy.hotplace.model.service;

import com.ssafy.hotplace.model.dao.HotPlaceRepository;
import com.ssafy.hotplace.model.dto.HotPlace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class HotPlaceServiceImpl implements HotPlaceService {
    private final HotPlaceRepository mapper;


    @Override
    public void insert(HotPlace hotplace) throws SQLException {
        mapper.insert(hotplace);
    }

    @Override
    public void update(HotPlace hotplace) throws SQLException {
        mapper.update(hotplace);
    }
}
