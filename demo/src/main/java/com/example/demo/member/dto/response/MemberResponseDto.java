package com.example.demo.member.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto {


    private String Id;
    private String loginId;
    private String displayName;
    private String email;


}
