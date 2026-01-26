package com.example.demo.domain.board;

import com.example.demo.domain.board.dto.request.CreateItemRequest;
import com.example.demo.domain.board.dto.request.UpdateItemRequest;
import com.example.demo.domain.board.dto.response.ItemResponseDto;
import com.example.demo.domain.board.dto.response.CreateItemResponse;
import com.example.demo.domain.board.dto.response.UpdateItemResponse;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {


    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    @Override
    @Transactional
    public CreateItemResponse createItem(CreateItemRequest request,String loginId) {

        System.out.println("loginId = " + loginId);
        // 1. DB에서 로그인한 유저를 찾습니다.
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."+loginId));


        Item item = Item.builder()
                .title(request.getTitle())
                .text(request.getText())
                .member(member)
                .build();

        itemRepository.save(item);

        CreateItemResponse response = CreateItemResponse.builder()
                .title(item.getTitle())
                .text(item.getText())
                .build();

        return response;
    }

    @Override
    @Transactional
    public UpdateItemResponse editItem(UpdateItemRequest request) {


        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 존재하지 않습니다. ID: " + request.getItemId()));


        item.update(request.getTitle(), request.getText());

        return UpdateItemResponse.builder()
                .title(item.getTitle())
                .text(item.getText())
                .build();
    }

    @Override
    @Transactional
    public UpdateItemResponse deleteItem(UpdateItemRequest request) {

        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 존재하지 않습니다. ID: " + request.getItemId()));


        itemRepository.delete(item);

        return UpdateItemResponse.builder()
                .itemId(item.getItemId())
                .build();
    }

    @Override
    @Transactional
    public ItemResponseDto findItem(Long itemId) {

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + itemId));

        return new ItemResponseDto(item);
    }


    @Override
    @Transactional(readOnly = true) // 성능 최적화 (조회 전용)
    public List<ItemResponseDto> findAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(item -> new ItemResponseDto(item)) // 또는 ItemResponseDto::new
                .collect(Collectors.toList());
    }
}
