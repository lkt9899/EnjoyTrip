package com.ssafy.map.model.service;


import com.ssafy.map.model.dao.MapRepository;
import com.ssafy.map.model.dto.LocationCodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MapService {
    private final MapRepository mapper;

    public List<LocationCodeDto> getSido() {
        return mapper.getSido();
    }

    public List<LocationCodeDto> getGugunInSido(String sidoCode) {
        return mapper.getGugunInSido(sidoCode);
    }

    public List<LocationCodeDto> getContentType() {
        return mapper.getContentType();
    }

}
