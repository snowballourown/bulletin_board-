package com.example.demo.member.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Schema(description = "사용자 생성 응답 객체")
public class CreateMemberResponse {

    @Schema(description = "사용자 닉네임", example = "프로젝트 시작하기", requiredMode = Schema.RequiredMode.REQUIRED)
    private String displayName;

    @Schema(description = "사용자 이메일", example = "오늘은 협업 인프라를 구축하는 날입니다.")
    private String email;

}

