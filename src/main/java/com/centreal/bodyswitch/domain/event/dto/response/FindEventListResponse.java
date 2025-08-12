package com.centreal.bodyswitch.domain.event.dto.response;

import com.centreal.bodyswitch.domain.event.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindEventListResponse {

    private List<EventItem> events;
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private int size;
    private boolean hasNext;
    private boolean hasPrevious;

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventItem {
        private Long id;
        private String title;
        private String content;
        private LocalDate endTime;
        private String imageUrl;

        public static EventItem from(Event event) {
            return EventItem.builder()
                    .id(event.getId())
                    .title(event.getTitle())
                    .content(event.getContent())
                    .endTime(event.getEndDate())
                    .imageUrl(event.getImageUrl().getFirst())
                    .build();
        }
    }

    public static FindEventListResponse from(Page<Event> page) {
        List<EventItem> eventItems = page.getContent().stream()
                .map(EventItem::from)
                .toList();

        return FindEventListResponse.builder()
                .events(eventItems)
                .currentPage(page.getNumber())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .size(page.getSize())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .build();
    }
}