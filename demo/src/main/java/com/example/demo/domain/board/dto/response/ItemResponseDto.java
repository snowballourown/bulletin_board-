package com.example.demo.domain.board.dto.response;

import com.example.demo.domain.board.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ItemResponseDto {

    private Long id;
    private String title;
    private String text;
    private String name; // 작성자 필드 추가

    // 엔티티를 DTO로 변환하는 생성자
    public ItemResponseDto(Item item) {
        this.id = item.getItemId();
        this.title = item.getTitle();
        this.text = item.getText();
        if(item.getMember() != null){
            this.name = item.getMember().getLoginId();
        } else{
            this.name = "알 수 없음";
        }
    }
}
