package com.example.demo.domain.board.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Schema(description = "아이템 생성 요청 객체")
public class UpdateItemResponse {

    @Schema(description = "아이템 id", example = "아이템 id")
    private Long itemId;

    @Schema(description = "아이템 제목", example = "프로젝트 시작하기", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "아이템 본문 내용", example = "오늘은 협업 인프라를 구축하는 날입니다.")
    private String text;

}