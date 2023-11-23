package com.ssafy.attraction.model.dao;

import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.util.model.dto.PagingInfo;
import com.ssafy.util.model.dto.request.MainQueryParams;
import com.ssafy.util.model.dto.request.RequestPosition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AttractionRepositoryTest {

  @Autowired
  private AttractionRepository repository;

  @Test
  void getAttractionPerPageByUser() {
    MainQueryParams mainQueryParams = new MainQueryParams();
    PagingInfo pagingInfo = new PagingInfo();
    pagingInfo.setCount(10);
    pagingInfo.setLastItemId(0);
    RequestPosition requestPosition = new RequestPosition();
    requestPosition.setLongitude(127.0120448);//127.0120448, 37.535744)
    requestPosition.setLatitude(37.535744);
    mainQueryParams.setPagingInfo(pagingInfo);
    mainQueryParams.setLng("127.0120448");
    mainQueryParams.setLat("37.535744");
    List<Attraction> attractionList = repository.getAttractionPerPageByUser(mainQueryParams);

    assertEquals(10, attractionList.size());

  }
}