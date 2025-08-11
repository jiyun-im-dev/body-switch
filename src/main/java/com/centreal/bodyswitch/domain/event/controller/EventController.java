package com.centreal.bodyswitch.domain.event.controller;

import com.centreal.bodyswitch.domain.event.constant.EventFilterType;
import com.centreal.bodyswitch.domain.event.dto.response.EventListResponse;
import com.centreal.bodyswitch.domain.event.dto.response.FindEventResponse;
import com.centreal.bodyswitch.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public ResponseEntity<EventListResponse> findEventList(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(name = "filter", defaultValue = "UPCOMING") EventFilterType filterType,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        EventListResponse response = eventService.findEventList(date, filterType, page, size);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindEventResponse> findEvent(
            @PathVariable(name = "id") Long id
    ) {
        FindEventResponse response = eventService.findEvent(id);

        return ResponseEntity.ok(response);
    }

}
