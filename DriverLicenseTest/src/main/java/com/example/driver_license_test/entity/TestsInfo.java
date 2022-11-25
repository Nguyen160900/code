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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tests_info")
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TestsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "date_real_test")
    private LocalDateTime dateRealTest;

    @NonNull
    @Column(name = "date_mock_test")
    private LocalDateTime dateMockTest;

    @NonNull
    @Column(name = "date_open")
    private LocalDateTime dateOpen;

    @NonNull
    @Column(name = "date_close")
    private LocalDateTime dateClose;

    @NonNull
    @Column(name = "number_subscription")
    private Integer numberSubscription;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "user")
    private List<UserTest> listUserTest;
}
