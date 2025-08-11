package com.centreal.bodyswitch.domain.event.service;

import com.centreal.bodyswitch.domain.event.constant.EventFilterType;
import com.centreal.bodyswitch.domain.event.dto.response.EventListResponse;
import com.centreal.bodyswitch.domain.event.dto.response.FindEventListResponses;
import com.centreal.bodyswitch.domain.event.entity.Event;
import com.centreal.bodyswitch.domain.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public EventListResponse getEventList(LocalDate date, EventFilterType filterType, Pageable pageable) {
        Page<Event> events = eventRepository.findEvents(date, filterType, pageable);

        Page<FindEventListResponses> eventListResponses = events.map(FindEventListResponses::from);

        return EventListResponse.from(eventListResponses);

    }
}
