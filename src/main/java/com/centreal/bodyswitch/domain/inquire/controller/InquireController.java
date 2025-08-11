package com.centreal.bodyswitch.domain.inquire.controller;

import com.centreal.bodyswitch.domain.inquire.dto.request.InquireRequest;
import com.centreal.bodyswitch.domain.inquire.service.InquireService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inquiries")
public class InquireController {

    private final InquireService inquireService;

    @PostMapping
    public ResponseEntity<Void> submitInquire(@Valid @RequestBody InquireRequest request) {
        inquireService.createInquire(request);
        return ResponseEntity.noContent().build();
    }
}
