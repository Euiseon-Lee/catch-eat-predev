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
    private String address;  // 매장 주소 (전체 문자열)
    private boolean opened;  // 영업 여부

    private String province;    // 도/광역시/특별시
    private String city;        // 시/구/군
    private String district;    // 동/읍/면
    private String roadAddress; // 도로명 주소
    private String lotAddress;  // 지번 주소 (필요하면)
    private Double latitude;    // 위도 (lat, Y)
    private Double longitude;   // 경도 (lng, X)

}