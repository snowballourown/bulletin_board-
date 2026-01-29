package com.example.demo.domain.member;


import com.example.demo.domain.board.dto.request.CreateItemRequest;
import com.example.demo.domain.board.dto.request.UpdateItemRequest;
import com.example.demo.domain.board.dto.response.CreateItemResponse;
import com.example.demo.domain.board.dto.response.ItemResponseDto;
import com.example.demo.domain.board.dto.response.UpdateItemResponse;
import com.example.demo.domain.member.dto.request.CreateMemberRequest;
import com.example.demo.domain.member.dto.request.UpdateMemberRequest;
import com.example.demo.domain.member.dto.response.CreateMemberResponse;
import com.example.demo.domain.member.dto.response.MemberResponseDto;
import com.example.demo.domain.member.dto.response.UpdateMemberResponse;

import java.util.List;

public interface MemberService {

    public CreateMemberResponse createMember(CreateMemberRequest request);
    UpdateMemberResponse editMember(Long Id, UpdateMemberRequest updateMemberRequest);
    UpdateMemberResponse deleteMember(UpdateMemberRequest request);
    public MemberResponseDto findMember(String loginId);
    public List<MemberResponseDto> findAll();

}
