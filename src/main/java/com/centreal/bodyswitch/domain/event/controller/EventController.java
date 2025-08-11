package com.centreal.bodyswitch.domain.event.controller;

import com.centreal.bodyswitch.domain.event.constant.EventFilterType;
import com.centreal.bodyswitch.domain.event.dto.response.EventListResponse;
import com.centreal.bodyswitch.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public ResponseEntity<EventListResponse> getEventList(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(name = "filter", defaultValue = "UPCOMING") EventFilterType filterType,
            @PageableDefault(size = 10, sort = "createdAt, desc") Pageable pageable
    ){
        EventListResponse eventList = eventService.getEventList(date, filterType, pageable);

        return ResponseEntity.ok(eventList);
    }

}
