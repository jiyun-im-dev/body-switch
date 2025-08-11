package com.centreal.bodyswitch.domain.inquire.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InquireRequest {

    private final String name;
    private String company;
    private String position;
    private String number;
    private String phoneNumber;
    private String email;
    private String content;
}