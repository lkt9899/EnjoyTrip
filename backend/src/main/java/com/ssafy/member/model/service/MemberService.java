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
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void register(Member member) throws SQLException {
        memberRepository.register(member);
    }

    public Member login(String id, String password) throws SQLException {
        return memberRepository.selectMemberById(id);
    }

    public Member selectMemberByMemberId(int memberId) throws SQLException{
        return memberRepository.selectMemberByMemberId(memberId);
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
