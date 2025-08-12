package com.centreal.bodyswitch.domain.event.constant;

import com.centreal.bodyswitch.common.response.ResponseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EventSuccess implements ResponseCode {
    EVENT_LIST_FIND_SUCCESS(HttpStatus.OK, "이벤트 목록 조회 성공", "EVENT_LIST_FIND_SUCCESS");

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;
}
