package com.example.demo.domain.member.dto.response;


import com.example.demo.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {


    private Long Id;
    private String loginId;
    private String displayName;
    private String email;


    public MemberResponseDto(Member memberResponseDto) {
        Id = memberResponseDto.getId();
        this.loginId = memberResponseDto.getLoginId();
        this.displayName = memberResponseDto.getDisplayName();
        this.email = memberResponseDto.getEmail();
    }
}
