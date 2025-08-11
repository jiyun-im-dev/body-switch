package com.centreal.bodyswitch.domain.notice.controller;

import com.centreal.bodyswitch.common.response.CommonResponse;
import com.centreal.bodyswitch.domain.notice.dto.response.NoticeResponse;
import com.centreal.bodyswitch.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<CommonResponse<Page<NoticeResponse>>> getNoticeList(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @PageableDefault(size = 10, sort = "createdAt, desc") Pageable pageable
    ) {
        Page<NoticeResponse> noticeList = noticeService.getNoticeList(keyword, pageable);

        CommonResponse<Page<NoticeResponse>> response = CommonResponse.of(
                HttpStatus.OK.toString(), // "200 OK"
                "공지사항 목록 조회 성공",
                noticeList
        );

        return ResponseEntity.ok(response);
    }
}