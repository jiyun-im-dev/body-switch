package com.centreal.bodyswitch.domain.event.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @Column(name = "view_count")
    private Integer viewCount = 0;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(name = "image_url")
    private String imageUrl;

    public void increaseViewCount() {
        this.viewCount++;
    }

}
