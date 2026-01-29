package com.example.demo.domain.member;


import com.example.demo.domain.board.dto.request.CreateItemRequest;
import com.example.demo.domain.board.dto.request.UpdateItemRequest;
import com.example.demo.domain.board.dto.response.ItemResponseDto;
import com.example.demo.domain.member.dto.request.CreateMemberRequest;
import com.example.demo.domain.member.dto.request.UpdateMemberRequest;
import com.example.demo.domain.member.dto.response.CreateMemberResponse;
import com.example.demo.domain.member.dto.response.MemberResponseDto;
import com.example.demo.domain.member.dto.response.UpdateMemberResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImple implements MemberService {


    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public boolean checkIdDuplicate(String loginId) {
        return memberRepository.existsByLoginId(loginId);
    }

    public boolean checkEmailDuplicate(String Email) {
        return memberRepository.existsByEmail(Email);
    }

    @Override
    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest request) {

        Optional<Member> member = memberRepository.findByLoginId(request.getLoginId());
        if (!member.isEmpty()) {
            throw new IllegalArgumentException("존재하는 아이디 입니다." + request.getEmail());
        }

        member = memberRepository.findByEmail(request.getEmail());

        if (!member.isEmpty()) {
            throw new IllegalArgumentException("존재하는 이메일 입니다." + request.getEmail());
        }




        Member member_certify = Member
                .builder()
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .displayName(request.getDisplayName())
                .loginId(request.getLoginId()).build();
        memberRepository.save(member_certify);

        CreateMemberResponse createMemberResponse = new CreateMemberResponse();
        createMemberResponse.setDisplayName(request.getDisplayName());
        createMemberResponse.setEmail(request.getEmail());

        return createMemberResponse;
    }

    @Override
    @Transactional
    public UpdateMemberResponse editMember(Long id,UpdateMemberRequest request) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            throw new IllegalArgumentException("해당 아이디는 존재않습니다");
        }

        member.get().setDisplayName(request.getDisplayName());
        UpdateMemberResponse updateMemberResponse = new UpdateMemberResponse();
        updateMemberResponse.setDisplayName(request.getDisplayName());
        updateMemberResponse.setEmail(request.getEmail());

        return updateMemberResponse;
    }

    @Override
    @Transactional
    public UpdateMemberResponse deleteMember(UpdateMemberRequest request)
    { Optional<Member> member = memberRepository.findByLoginId(request.getLoginId());
        if (member.isPresent()) {
            throw new IllegalArgumentException("해당 아이디는 존재않습니다");
        }
        UpdateMemberResponse updateMemberResponse = new UpdateMemberResponse();
        updateMemberResponse.setDisplayName(request.getDisplayName());
        updateMemberResponse.setEmail(request.getEmail());


        memberRepository.delete(member.get());

        return updateMemberResponse;
    }

    @Override
    public MemberResponseDto findMember(String loginId) {
        Optional<Member> member = memberRepository.findByLoginId(loginId);
        if (member.isPresent()) {
            throw new IllegalArgumentException("해당 아이디는 존재않습니다");
        }

        MemberResponseDto memberResponseDto = MemberResponseDto.builder()
                .email(member.get().getEmail())
                .loginId(member.get().getLoginId())
                .displayName(member.get().getDisplayName())
                .Id(member.get().getId())
                .build();

        return memberResponseDto;
    }

    @Override
    public List<MemberResponseDto> findAll() {
        List<Member> all = memberRepository.findAll();

        return all.stream()
                .map(Member -> new MemberResponseDto(Member)) // 또는 ItemResponseDto::new
                .collect(Collectors.toList());
    }
}
