package com.example.demo.domain.member;


import com.example.demo.domain.member.dto.response.MemberResponseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
public class Member {

    @Id
    @GeneratedValue
    Long Id;

    @Column(unique = true)
    String loginId;
    String password;
    @Column(unique = true)
    String displayName;

    @Column(unique = true)
    String email;


}
