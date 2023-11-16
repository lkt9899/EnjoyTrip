package com.ssafy.member.controller;

import com.ssafy.member.model.dto.Member;
import com.ssafy.member.model.dto.MemberLoginRequest;
import com.ssafy.member.model.dto.request.MemberDeleteRequest;
import com.ssafy.member.model.dto.request.MemberUpdateRequest;
import com.ssafy.member.model.dto.response.MemberInfoResponse;
import com.ssafy.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping ("/register")
    public ResponseEntity<?> register(@RequestBody Member member){
        try {
            MemberInfoResponse loginMember = memberService.register(member);
            log.info("=====loginMember======= "+loginMember);
            return ResponseEntity.status(HttpStatus.CREATED).body(loginMember);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest req){
        try {
            MemberInfoResponse loginMember = memberService.login(req.getId(), req.getPassword());
            if(loginMember != null)
                return ResponseEntity.status(HttpStatus.OK).body(loginMember);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (SQLException e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        if(session.getAttribute("loginInfo") != null ) session.invalidate(); //session 소멸
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody MemberUpdateRequest member){
        try {
            memberService.update(member);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody int memberId) {
        try {
            memberService.delete(memberId);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
