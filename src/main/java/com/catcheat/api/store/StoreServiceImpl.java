package com.catcheat.api.store;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreResponseDto create(StoreRequestDto requestDto) {
        Store store = new Store();
        store.setCode(requestDto.getCode());
        store.setName(requestDto.getName());
        store.setAddress(requestDto.getAddress());
        store.setOpened(requestDto.isOpened());

        Store saved = storeRepository.save(store);
        return StoreResponseDto.from(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public StoreResponseDto get(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store not found: " + id));
        return StoreResponseDto.from(store);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StoreResponseDto> getAll() {
        return storeRepository.findAll().stream()
                .map(StoreResponseDto::from)
                .toList();
    }

    @Override
    public StoreResponseDto update(Long id, StoreRequestDto requestDto) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store not found: " + id));

        store.setCode(requestDto.getCode());
        store.setName(requestDto.getName());
        store.setAddress(requestDto.getAddress());
        store.setOpened(requestDto.isOpened());

        return StoreResponseDto.from(store);
    }

    @Override
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}