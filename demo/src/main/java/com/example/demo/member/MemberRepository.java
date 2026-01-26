package com.example.demo.member;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String Email);

    Optional<Member> findByLoginId(String loginId);

    // loginId 필드가 존재하는지 확인 (T/F 반환)
    boolean existsByLoginId(String loginId);
    boolean existsByEmail(String email);

}
