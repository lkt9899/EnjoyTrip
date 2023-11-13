package com.ssafy.attraction.model.service;

import com.ssafy.attraction.model.dao.AttractionRepository;
import com.ssafy.attraction.model.dto.AttractionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AttractionService {

   private final AttractionRepository mapper;

   public List<AttractionInfo> selectAll() throws SQLException{
      return mapper.selectAll();
   }

}
