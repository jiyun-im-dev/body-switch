package com.centreal.bodyswitch.domain.notice.dto.response;

import com.centreal.bodyswitch.domain.notice.entity.Notice;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class NoticeResponse {

    private final Long id;
    private final String title;
    private final String author;
    private final String content;
    private final Integer viewCount;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static NoticeResponse from(Notice notice) {
        return NoticeResponse.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .author(notice.getAuthor())
                .content(notice.getContent())
                .viewCount(notice.getViewCount())
                .startDate(notice.getStartDate())
                .endDate(notice.getEndDate())
                .build();
    }
}