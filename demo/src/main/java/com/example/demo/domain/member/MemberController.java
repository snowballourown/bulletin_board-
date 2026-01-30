package com.example.demo.domain.member;


import com.example.demo.domain.member.dto.request.CreateMemberRequest;
import com.example.demo.domain.member.dto.request.UpdateMemberRequest;
import com.example.demo.domain.member.dto.response.CreateMemberResponse;
import com.example.demo.domain.member.dto.response.MemberResponseDto;
import com.example.demo.domain.member.dto.response.UpdateMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;
    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<CreateMemberResponse> userRegister(@RequestBody CreateMemberRequest request) {
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
    @PatchMapping("/edit")
    public ResponseEntity<UpdateMemberResponse> edit(@PathVariable Long id, @RequestBody UpdateMemberRequest request) {
        UpdateMemberResponse response = memberService.editMember(id, request);
        return ResponseEntity.ok(response);
    }


    @ResponseBody
    @GetMapping("/member/all")
    public ResponseEntity<List<MemberResponseDto>> memberFindAll() {
        List<MemberResponseDto> response = memberService.findAll();
        return ResponseEntity.ok(response);
    }

    @ResponseBody
    @GetMapping("/member/{id}")
    public ResponseEntity<MemberResponseDto> findMember(@PathVariable Long id) {
        MemberResponseDto response = memberService.findMember(id);
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
