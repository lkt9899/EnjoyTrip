package com.ssafy.member.controller;

import com.ssafy.member.model.dto.Member;
import com.ssafy.member.model.dto.MemberLoginRequest;
import com.ssafy.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping ("/register")
    public ResponseEntity<String> register(@RequestBody Member member) {
        memberService.register(member);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest req){
        Member member = memberService.login(req.getId(), req.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        if(session.getAttribute("userinfo") != null ) session.invalidate(); //session 소멸
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestParam Member member){
        memberService.update(member);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam int memberId) {
        memberService.delete(memberId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
