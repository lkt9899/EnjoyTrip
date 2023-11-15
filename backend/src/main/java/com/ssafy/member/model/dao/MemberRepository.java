package com.ssafy.member.model.dao;

import com.ssafy.member.model.dto.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberRepository {


   void register(Member member);
   int existsById(String id);
   Member findById(String id);
   void update(Member member);
   void delete(int memberId);


}
