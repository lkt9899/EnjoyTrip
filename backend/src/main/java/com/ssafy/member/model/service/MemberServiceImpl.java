package com.ssafy.member.model.service;
import com.ssafy.member.model.dao.MemberRepository;
import com.ssafy.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public void register(Member member) throws SQLException {
        memberRepository.register(member);
    }

    @Override
    public Member login(String id, String password) throws SQLException {
        Member member = memberRepository.select(id);
        if(member.getPassword().equals(password))
            return member;
        return null;
    }

    @Transactional
    @Override
    public void update(Member member) throws SQLException {
        memberRepository.update(member);
    }

    @Transactional
    @Override
    public void delete(int memberId) throws SQLException {
        memberRepository.delete(memberId);
    }
}
