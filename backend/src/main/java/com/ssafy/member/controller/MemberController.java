package com.ssafy.member.controller;

import com.ssafy.member.model.dto.Member;
import com.ssafy.member.model.dto.MemberLoginRequest;
import com.ssafy.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
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


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberServiceImpl;

    @PostMapping ("/register")
    public ResponseEntity<String> register(@RequestBody Member member){
        try {
            memberServiceImpl.register(member);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest req){
        try {
            Member member = memberServiceImpl.login(req.getId(), req.getPassword());
            if(member != null)
                return ResponseEntity.status(HttpStatus.OK).body(member);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (SQLException e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        if(session.getAttribute("userinfo") != null ) session.invalidate(); //session 소멸
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam Member member){
        try {
            memberServiceImpl.update(member);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String id) {
        try {
            memberServiceImpl.delete(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
