package com.centreal.bodyswitch.domain.event.dto.response;

import com.centreal.bodyswitch.domain.event.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindEventListResponses {

    private Long id;
    private String title;
    private String content;
    private LocalDate endTime;
    private String imageUrl;

    public static FindEventListResponses from(Event event) {
        return FindEventListResponses.builder()
                .id(event.getId())
                .title(event.getTitle())
                .content(event.getContent())
                .endTime(event.getEndDate())
                .imageUrl(event.getImageUrl().getFirst())
                .build();
    }

}
