package com.example.driver_license_test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "fees")
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "application")
    private Integer application;

    @NonNull
    @Column(name = "theoretical")
    private Integer theoretical;

    @NonNull
    @Column(name = "pratice")
    private Integer pratice;

    @NonNull
    @Column(name = "card")
    private Integer card;

    @NonNull
    @Column(name = "time_save")
    private LocalDate timeSave;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
}
