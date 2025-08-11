package com.centreal.bodyswitch.domain.inquire.service;

import com.centreal.bodyswitch.domain.inquire.dto.request.InquireRequest;
import com.centreal.bodyswitch.domain.inquire.entity.Inquire;
import com.centreal.bodyswitch.domain.inquire.repository.InquireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InquireService {

    private final InquireRepository inquireRepository;

    @Transactional
    public void createInquire(InquireRequest request) {
        Inquire inquire = Inquire.builder()
                .name(request.getName())
                .company(request.getCompany())
                .position(request.getPosition())
                .number(request.getNumber())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .content(request.getContent())
                .build();

        inquireRepository.save(inquire);
    }
}
