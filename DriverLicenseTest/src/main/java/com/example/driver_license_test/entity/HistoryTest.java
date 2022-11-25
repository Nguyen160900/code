package com.example.driver_license_test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "history_test")
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class HistoryTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @Column(name = "time_save")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timeSave;

    @Column(name = "status")
    private String status;

    @Column(name = "point")
    private Integer point;

    @OneToMany(mappedBy = "historyTest")
    private List<UserAnswer> listUserAnswer;
}
