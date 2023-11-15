package com.ssafy.member.model.service;
import com.ssafy.member.model.dao.MemberRepository;
import com.ssafy.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;

    public int selectCountOfMember() throws SQLException {
        return memberRepository.selectCountOfMember();
    }
    @Transactional
    public void register(Member member) throws SQLException {
        memberRepository.register(member);
    }

    public Member login(String id, String password) throws SQLException {
        Member member = memberRepository.select(id);
        if(member.getPassword().equals(password))
            return member;
        return null;
    }

    @Transactional
    public void update(Member member) throws SQLException {
        memberRepository.update(member);
    }

    @Transactional
    public void delete(int memberId) throws SQLException {
        memberRepository.delete(memberId);
    }
}
