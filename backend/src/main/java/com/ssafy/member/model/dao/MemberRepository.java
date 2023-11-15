package com.ssafy.member.model.dao;

import com.ssafy.member.model.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;


@Mapper
public interface MemberRepository {

   void register(Member member) throws SQLException;
   Member selectMemberByMemberId(int memberId) throws SQLException;
   Member selectMemberById(String id) throws SQLException;
   void update(Member member) throws SQLException;
   void delete(int memberId) throws SQLException;



}
