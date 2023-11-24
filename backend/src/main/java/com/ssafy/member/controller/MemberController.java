package com.ssafy.member.controller;

import com.ssafy.member.model.dto.Member;
import com.ssafy.member.model.dto.data.request.MemberLoginRequest;
import com.ssafy.member.model.dto.data.request.MemberUpdateRequest;
import com.ssafy.member.model.dto.data.response.MemberLoginResponse;
import com.ssafy.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberLoginResponse> register(@RequestBody Member member) {
        MemberLoginResponse loginMember = memberService.register(member);
        log.info("=====loginMember======= "+loginMember);
        return ResponseEntity.status(HttpStatus.CREATED).body(loginMember);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest req) {
        MemberLoginResponse res = memberService.login(req.getId(), req.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/idcheck")
    public ResponseEntity<Boolean> idCheck (@RequestBody MemberLoginRequest req){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.idCheck(req.getId()));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        if (session.getAttribute("loginInfo") != null)
            session.invalidate(); // session 소멸
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody MemberUpdateRequest member) {
        memberService.update(member);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<Void> delete(@PathVariable int memberId) {
        memberService.delete(memberId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
