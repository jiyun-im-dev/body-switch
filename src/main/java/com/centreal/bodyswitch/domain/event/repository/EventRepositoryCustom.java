package com.centreal.bodyswitch.domain.event.repository;

import com.centreal.bodyswitch.domain.event.constant.EventFilterType;
import com.centreal.bodyswitch.domain.event.entity.Event;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

public interface EventRepositoryCustom {
    Page<Event> findEvents(LocalDate date, EventFilterType filterType, Pageable pageable);
}
