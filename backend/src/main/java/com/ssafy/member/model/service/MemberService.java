package com.ssafy.member.model.service;

import com.ssafy.member.exception.MemberErrorCode;
import com.ssafy.member.exception.MemberException;
import com.ssafy.member.model.dao.MemberRepository;
import com.ssafy.member.model.dto.Member;
import com.ssafy.member.model.dto.data.request.MemberUpdateRequest;
import com.ssafy.member.model.dto.data.response.MemberLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository mapper;

    public int getCountOfMember() {
      return mapper.getCountOfMember();
    }
    @Transactional
    public MemberLoginResponse register(Member member) {
        // 아이디 중복 여부 확인
        if (mapper.existsById(member.getId()) != 0) {
            throw new MemberException(MemberErrorCode.ID_ALREADY_EXISTS);
        }

        mapper.register(member);
        return mapper.findById(member.getId());
    }

    // TODO : password, id 유효성 검사
    public MemberLoginResponse login(String id, String password) {
        // 아이디 존재 여부 확인
        if (mapper.existsById(id) == 0)
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);
        // 비밀 번호 확인
        MemberLoginResponse member = mapper.findById(id);
        if (!member.getPassword().equals(password))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return member;
    }

    @Transactional
    public void update(MemberUpdateRequest member) {
        mapper.update(member);
    }

    @Transactional
    public void delete(int memberId) {
        if(mapper.findByMemberId(memberId) == null)
            throw new MemberException(MemberErrorCode.NOT_EXIST_MEMBER);

        mapper.delete(memberId);
    }
}
