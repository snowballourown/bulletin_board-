package com.example.demo.domain.member.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "사용자 수정 응답 객체")
public class UpdateMemberResponse {

    @Schema(description = "사용자 id", example = "사용자 id")
    private String loginId;

    @Schema(description = "사용자 닉네임")
    private String displayName;

    @Schema(description = "사용자 이메일")
    private String email;


}