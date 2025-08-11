package com.centreal.bodyswitch.domain.notice.service;

import com.centreal.bodyswitch.domain.notice.dto.response.NoticeResponse;
import com.centreal.bodyswitch.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public Page<NoticeResponse> getNoticeList(String keyword, Pageable pageable) {
        return noticeRepository.findByTitleContaining(keyword, pageable).map(NoticeResponse::from);
    }
}
