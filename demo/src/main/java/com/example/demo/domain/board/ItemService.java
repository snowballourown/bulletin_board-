package com.example.demo.domain.board;


import com.example.demo.domain.board.dto.request.CreateItemRequest;
import com.example.demo.domain.board.dto.request.UpdateItemRequest;
import com.example.demo.domain.board.dto.response.ItemResponseDto;
import com.example.demo.domain.board.dto.response.CreateItemResponse;
import com.example.demo.domain.board.dto.response.UpdateItemResponse;

import java.util.List;

public interface ItemService {



    public CreateItemResponse createItem(CreateItemRequest request, String loginId);
    UpdateItemResponse editItem(UpdateItemRequest request);
    UpdateItemResponse deleteItem(UpdateItemRequest request);
    public ItemResponseDto findItem(Long itemId);
    public List<ItemResponseDto> findAll();

}
