package com.centreal.bodyswitch.domain.event.service;

import com.centreal.bodyswitch.domain.event.constant.EventFilterType;
import com.centreal.bodyswitch.domain.event.dto.response.FindEventListResponse;
import com.centreal.bodyswitch.domain.event.dto.response.FindEventResponse;
import com.centreal.bodyswitch.domain.event.entity.Event;
import com.centreal.bodyswitch.domain.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public FindEventListResponse findEventList(LocalDate date, EventFilterType filterType, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> events = eventRepository.findEvents(date, filterType, pageable);

        return FindEventListResponse.from(events);

    }

    public FindEventResponse findEvent(Long id) {
        return eventRepository.findEvent(id);
    }
}
