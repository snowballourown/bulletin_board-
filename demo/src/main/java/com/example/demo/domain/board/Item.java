package com.example.demo.domain.board;

import com.example.demo.member.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name ="title")
    private String title;

    @Column(name ="text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="loginId")
    private Member member;

    public void update(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
