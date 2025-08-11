package com.centreal.bodyswitch.domain.inquire.entity;

import com.centreal.bodyswitch.domain.inquire.constant.InquireStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "inquire")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String company;

    private String position;

    private String number;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private InquireStatus status = InquireStatus.PENDING;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Builder
    public Inquire(String name, String company, String position, String number, String phoneNumber, String email, String content) {
        this.name = name;
        this.company = company;
        this.position = position;
        this.number = number;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.content = content;
    }
}
