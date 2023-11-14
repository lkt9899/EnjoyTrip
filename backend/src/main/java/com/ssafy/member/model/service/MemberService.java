package com.ssafy.member.model.service;



import com.ssafy.member.model.dto.Member;

import java.sql.SQLException;


public interface MemberService {

   void register(Member member) throws SQLException;
   Member login(String id, String password) throws SQLException;
   void update(Member member) throws SQLException;
   void delete(int memberId) throws SQLException;


}
