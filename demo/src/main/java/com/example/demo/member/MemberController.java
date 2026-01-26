package com.example.demo.member;


import com.example.demo.SecurityConfig;
import com.example.demo.member.dto.response.CreateMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class MemberController {


    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

//    @PostMapping("/register")
//    public  ResponseEntity<CreateMemberResponse> userRegister(
//            @RequestParam String loginId,
//            @RequestParam String password,
//            @RequestParam String displayName,
//            @RequestParam String email
//    ) {
//
//        //중복 아이디 불가
//        //중복 이메일있음
//        //중복 닉네임
//        //password 해쉬로저장
//
//
//        if (!memberRepository.findByEmail(email).isEmpty()) {
//            throw new RuntimeException("중복된 이메일존재");
//        }
//
//
//
//
//
//        Member member = new Member();
//        member.setLoginId(loginId);
//        member.setPassword(passwordEncoder.encode(password));
//        member.setDisplayName(displayName);
//        member.setEmail(email);
//        memberRepository.save(member);
//
//
//
//
//        return ResponseEntity.ok(member);
//    }
//
//    @ResponseBody // 데이터를 직접 반환하기 위해 필수!
//    @GetMapping("/api/member/check-id")// 경로를 한 번에 작성하는 것이 명확합니다.
//    public ResponseEntity<Boolean> checkId(@RequestParam String loginId) {
//        return ResponseEntity.ok(memberService.checkIdDuplicate(loginId));
//    }
//
//    @ResponseBody // 데이터를 직접 반환하기 위해 필수!
//    @GetMapping("/api/member/check-email")// 경로를 한 번에 작성하는 것이 명확합니다.
//    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
//        return ResponseEntity.ok(memberService.checkEmailDuplicate(email));
//    }

    @GetMapping("/login")
    public void login() {
    }





    @GetMapping("/registerUser123")
    public void userRegisterhtml() {

    }

    @GetMapping("/lobi")
    public void lobilocation() {
    }

    @GetMapping("/root")
    public String hello() {

        return "helloWord";
    }


}
