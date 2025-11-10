package com.catcheat.api.store;

import java.util.List;

public interface StoreService {
    StoreResponseDto create(StoreRequestDto requestDto);
    StoreResponseDto get(Long id);
    List<StoreResponseDto> getAll();
    StoreResponseDto update(Long id, StoreRequestDto requestDto);
    void delete(Long id);
}