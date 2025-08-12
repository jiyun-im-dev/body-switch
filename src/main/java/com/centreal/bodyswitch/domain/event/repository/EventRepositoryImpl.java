package com.centreal.bodyswitch.domain.event.repository;

import com.centreal.bodyswitch.domain.event.constant.EventFilterType;
import com.centreal.bodyswitch.domain.event.dto.response.FindEventResponse;
import com.centreal.bodyswitch.domain.event.dto.response.QFindEventResponse;
import com.centreal.bodyswitch.domain.event.entity.Event;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

import static com.centreal.bodyswitch.domain.event.entity.QEvent.event;

public class EventRepositoryImpl implements EventRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public EventRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Event> findEvents(LocalDate date, EventFilterType filterType, Pageable pageable) {

        List<Event> eventList = queryFactory
                .selectFrom(event)
                .where(filterBy(date, filterType))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(event.startDate.desc())
                .fetch();

        Long total = queryFactory
                .select(event.count())
                .from(event)
                .where(filterBy(date, filterType))
                .fetchOne();

        return new PageImpl<>(eventList, pageable, total != null ? total : 0L);
    }

    @Override
    public FindEventResponse findEvent(Long id) {
        return queryFactory
                .select(new QFindEventResponse(
                        event.title,
                        event.content,
                        event.imageUrl,
                        event.endDate
                ))
                .from(event)
                .where(event.id.eq(id))
                .fetchOne();
    }

    private BooleanExpression filterBy(LocalDate date, EventFilterType filterType) {
        if (filterType == null) {
            return null;
        }

        if (filterType == EventFilterType.PAST) {
            return event.endDate.lt(date);
        }

        return event.endDate.goe(date);
    }

}
