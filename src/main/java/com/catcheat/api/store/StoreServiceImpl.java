package com.catcheat.api.store;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreResponseDto create(StoreRequestDto requestDto) {
        Store store = Store.builder()
                .code(requestDto.getCode())
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .opened(requestDto.isOpened())
                .province(requestDto.getProvince())
                .city(requestDto.getCity())
                .district(requestDto.getDistrict())
                .roadAddress(requestDto.getRoadAddress())
                .lotAddress(requestDto.getLotAddress())
                .latitude(requestDto.getLatitude())
                .longitude(requestDto.getLongitude())
                .build();

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
                .collect(Collectors.toList());
    }

    @Override
    public StoreResponseDto update(Long id, StoreRequestDto requestDto) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store not found: " + id));

        store.setCode(requestDto.getCode());
        store.setName(requestDto.getName());
        store.setAddress(requestDto.getAddress());
        store.setOpened(requestDto.isOpened());
        store.setProvince(requestDto.getProvince());
        store.setCity(requestDto.getCity());
        store.setDistrict(requestDto.getDistrict());
        store.setRoadAddress(requestDto.getRoadAddress());
        store.setLotAddress(requestDto.getLotAddress());
        store.setLatitude(requestDto.getLatitude());
        store.setLongitude(requestDto.getLongitude());

        // JPA 영속 상태라 save() 없이도 flush 시점에 업데이트 되지만,
        // 명시적으로 반환값 받고 싶으면 save 호출
        Store updated = storeRepository.save(store);
        return StoreResponseDto.from(updated);
    }

    @Override
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}