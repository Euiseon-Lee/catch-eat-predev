package com.catcheat.api.store;

import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * [클라이언트] JSON 요청
 *    ↓
 * [Controller] StoreRequestDto 로 바인딩
 *    ↓
 * [Service] Store 엔티티 변환 → 저장
 *    ↓
 * [DB] store 테이블 insert
 *    ↓
 * [Service] Store → StoreResponseDto 변환
 *    ↓
 * [Controller] JSON 응답으로 반환
 *    ↓
 * [클라이언트] 화면 표시
 */
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public StoreResponseDto create(@RequestBody StoreRequestDto requestDto) {
        return storeService.create(requestDto);
    }

    @GetMapping("/{id}")
    public StoreResponseDto get(@PathVariable Long id) {
        return storeService.get(id);
    }

    @GetMapping
    public List<StoreResponseDto> getAll() {
        return storeService.getAll();
    }

    @PutMapping("/{id}")
    public StoreResponseDto update(@PathVariable Long id,
                                   @RequestBody StoreRequestDto requestDto) {
        return storeService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        storeService.delete(id);
    }
}
