package com.ssafy.attraction.model.service;

import com.ssafy.attraction.exception.AttractionErrorCode;
import com.ssafy.attraction.exception.AttractionException;
import com.ssafy.attraction.model.dao.AttractionRepository;
import com.ssafy.attraction.model.dto.Attraction;
import com.ssafy.util.model.dto.QueryParams;
import com.ssafy.util.model.dto.request.MainQueryParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AttractionService {

   private final AttractionRepository mapper;
   public List<Attraction> select(QueryParams params) {
      List<Attraction> list = mapper.getAttractionPerPage(params);
      if(list == null || list.isEmpty())
         throw new AttractionException(AttractionErrorCode.NO_CONTENTS_WITH_CONDITION);

      return list;
   }


   public List<Attraction> getAttractionPerPageByUser(MainQueryParams params){
      return mapper.getAttractionPerPageByUser(params);
   }
}
