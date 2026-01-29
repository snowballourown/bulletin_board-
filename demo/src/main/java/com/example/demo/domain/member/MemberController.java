package com.example.demo.domain.member;


import com.example.demo.domain.board.dto.response.ItemResponseDto;
import com.example.demo.domain.member.dto.request.CreateMemberRequest;
import com.example.demo.domain.member.dto.response.CreateMemberResponse;
import com.example.demo.domain.member.dto.response.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberRepository memberRepository;
    private final MemberService memberService;
    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<CreateMemberResponse> userRegister(CreateMemberRequest request) {
         CreateMemberResponse createMemberResponse = memberService.createMember(request);
        return ResponseEntity.ok(createMemberResponse);
    }
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

    @ResponseBody
    @GetMapping("/login")
    public ResponseEntity<MemberResponseDto> login(CreateMemberRequest createMemberRequest) {
        MemberResponseDto response= memberService.findMember(createMemberRequest.getLoginId());
        return ResponseEntity.ok(response);
    }

//
//    @GetMapping("/registerUser123")
//    public String userRegisterhtml() {
//        return "registerUser";
//    }
//
//    @GetMapping("/lobi")
//    public String lobilocation() {
//        return "lobi.html";
//    }
    @ResponseBody
    @GetMapping("/root")
    public String hello() {
        return "hell0wordㅎㅎ되겠지?????ㅎㅎㅎㅎㅎㅎㅎㅎ";
    }

}
