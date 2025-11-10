package com.catcheat.api.store;

/**
 *  서버가 클라이언트로 돌려주는 데이터 그릇
 *  주로 GET / POST 결과 응답에서 사용
 *  엔티티(Store)를 그대로 노출하지 않고, 필요한 데이터만 가공해서 내보냄
 *  보안, 응답 일관성, 확장성 측면에서 훨씬 안전함
 */
public class StoreResponseDto {
    private Long id;
    private String code;
    private String name;
    private String address;
    private boolean opened;

    public static StoreResponseDto from(Store store) {
        StoreResponseDto dto = new StoreResponseDto();
        dto.id = store.getId();
        dto.code = store.getCode();
        dto.name = store.getName();
        dto.address = store.getAddress();
        dto.opened = store.isOpened();
        return dto;
    }
}