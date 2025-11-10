package com.catcheat.api.store;

import lombok.Getter;
import lombok.Setter;

/**
 *  클라이언트가 서버로 보낼 때 쓰는 데이터 그릇
 *  주로 POST / PUT / PATCH 요청에 사용
 */
@Getter
@Setter
public class StoreRequestDto {
    private String code;     // 매장 코드
    private String name;     // 매장 이름
    private String address;  // 매장 주소
    private boolean opened;  // 영업 여부

}