package com.example.demo.domain.member.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "사용자 수정 요청 객체")
public class UpdateMemberRequest {

    @Schema(description = "사용자 id", example = "사용자 id")
    private String loginId;

    @Schema(description = "사용자 닉네임")
    private String displayName;

    @Schema(description = "사용자 이메일")
    private String email;


}