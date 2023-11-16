package com.ssafy.member.model.dao;

import com.ssafy.member.model.dto.Member;
import com.ssafy.member.model.dto.request.MemberDeleteRequest;
import com.ssafy.member.model.dto.request.MemberUpdateRequest;
import com.ssafy.member.model.dto.response.MemberInfoResponse;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;


@Mapper
public interface MemberRepository {

   void register(Member member) throws SQLException;
   MemberInfoResponse selectMemberByMemberId(int memberId) throws SQLException;
   MemberInfoResponse selectMemberById(String id) throws SQLException;
   void update(MemberUpdateRequest member) throws SQLException;
   void delete(int memberId) throws SQLException;

}
