package com.example.demo.domain.board.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@Schema(description = "아이템 생성 응답 객체")
public class CreateItemResponse {

    @Schema(description = "생성된 아이템 제목", example = "프로젝트 시작하기")
    private String title;

    @Schema(description = "생성된 아이템 본문 내용", example = "오늘은 협업 인프라를 구축하는 날입니다.")
    private String text;

}