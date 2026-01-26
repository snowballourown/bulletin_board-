package com.example.demo.domain.board;

import com.example.demo.domain.board.dto.request.CreateItemRequest;
import com.example.demo.domain.board.dto.request.UpdateItemRequest;
import com.example.demo.domain.board.dto.response.ItemResponseDto;
import com.example.demo.domain.board.dto.response.CreateItemResponse;
import com.example.demo.domain.board.dto.response.UpdateItemResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller; // RestController 대신 Controller 사용
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Tag(name = "Item API", description = "아이템 등록 및 관리를 위한 컨트롤러")
@Controller // 변경: 이제 이 클래스는 View 이름을 반환할 수 있습니다.
@RequestMapping("/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // ==========================================================
    // 1. 화면(View) 전용 메서드
    // ==========================================================
    @GetMapping("/view") // URL: http://localhost:8080/item/view
    public String boardPage(Model model) {
        List<ItemResponseDto> items = itemService.findAll();
        model.addAttribute("items", items);
        return "board"; // board.html 실행 (ResponseBody가 없어야 함)
    }

    // ==========================================================
    // 2. 글쓰기 전용 메소드
    // ==========================================================
    @GetMapping("/write") // URL: http://localhost:8080/item/board_write
    public String writePage( ) {
        return "board_write"; // board_write.html
    }


    // ==========================================================
    // 3. 글 수정 매소드
    // ==========================================================
    @GetMapping("/edit/{id}") // URL: http://localhost:8080/item/board
    public String editPage(@PathVariable Long id, Model model) {

        ItemResponseDto item = itemService.findItem(id);

        // 2. 모델에 담아서 HTML로 전달
        model.addAttribute("item", item);
        return "board_write";
    }

    // ==========================================================
    // 2. 데이터(API) 전용 메서드 (@ResponseBody 필수)
    // ==========================================================
    @PostMapping
    @ResponseBody // 추가: HTML이 아닌 JSON 데이터를 반환함
    @Operation(summary = "아이템 생성", description = "새로운 아이템 정보를 입력받아 저장합니다.")
    public ResponseEntity<CreateItemResponse> createItem(@RequestBody CreateItemRequest request,
                                                         Principal principal){
        // 1. 로그인할 때 쓴 ID(loginId)를 가져옵니다.
        String loginId = principal.getName();
        CreateItemResponse response = itemService.createItem(request,loginId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping
    @ResponseBody
    public ResponseEntity<UpdateItemResponse> editItem(@RequestBody UpdateItemRequest request){
        UpdateItemResponse response = itemService.editItem(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<UpdateItemResponse> deleteItem(@RequestBody UpdateItemRequest request){
        UpdateItemResponse response = itemService.deleteItem(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{itemId}")
    @ResponseBody
    public ResponseEntity<ItemResponseDto> getItem(@PathVariable Long itemId){
        ItemResponseDto response = itemService.findItem(itemId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/all") // 화면용 GET과 구분하기 위해 경로 조정 권장
    @ResponseBody
    public ResponseEntity<List<ItemResponseDto>> findAllItems() {
        List<ItemResponseDto> response = itemService.findAll();
        return ResponseEntity.ok(response);
    }


}