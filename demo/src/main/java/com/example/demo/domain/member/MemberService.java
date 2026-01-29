package com.example.demo.domain.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;


    public boolean checkIdDuplicate(String loginId) {
        return memberRepository.existsByLoginId(loginId);
    }
    public boolean checkEmailDuplicate(String Email) {
        return memberRepository.existsByEmail(Email);
    }
}
