package com.example.demo.domain.member;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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
