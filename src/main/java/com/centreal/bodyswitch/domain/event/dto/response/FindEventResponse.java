package com.centreal.bodyswitch.domain.event.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindEventResponse {
    private String title;
    private String content;
    private List<String> imgUrl;
    private LocalDate endDate;

    @QueryProjection
    public FindEventResponse(String title, String content, List<String> imgUrl, LocalDate endDate) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.endDate = endDate;
    }
}
