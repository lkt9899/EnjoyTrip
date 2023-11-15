package com.ssafy.member.model.service;
import com.ssafy.member.model.dao.MemberRepository;
import com.ssafy.member.model.dto.Member;
import com.ssafy.member.model.dto.request.MemberDeleteRequest;
import com.ssafy.member.model.dto.request.MemberUpdateRequest;
import com.ssafy.member.model.dto.response.MemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberInfoResponse register(Member member) throws SQLException {
        memberRepository.register(member);
        return memberRepository.selectMemberById(member.getId());
    }

    @Transactional
    /** 수정 필요: password, id 유효성 처리 **/
    public MemberInfoResponse login(String id, String password) throws SQLException {
        return memberRepository.selectMemberById(id);
    }

    public MemberInfoResponse selectMemberByMemberId(int memberId) throws SQLException{
        return memberRepository.selectMemberByMemberId(memberId);
    }

    @Transactional
    public void update(MemberUpdateRequest member) throws SQLException {
        memberRepository.update(member);
    }

    @Transactional
    public void delete(MemberDeleteRequest memberDeleteRequest) throws SQLException {
        memberRepository.delete(memberDeleteRequest);
    }
}
