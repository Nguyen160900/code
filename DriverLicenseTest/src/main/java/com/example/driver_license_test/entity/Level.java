package com.example.driver_license_test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "levels")
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "level_name")
    private String name;

    @NonNull
    @Type(type = "text")
    @Column(name = "descriptions", columnDefinition = "LONGTEXT")
    private String descriptions;

    @Column(name = "time_test")
    private Integer timeTest;

    @OneToMany(mappedBy = "level")
    private List<Question> listQuestion;

    @OneToMany(mappedBy = "level")
    private List<HistoryTest> listHistoryTest;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "level")
    private List<Fee> listFee;

    @OneToMany(mappedBy = "level")
    private List<TestsInfo> listTestsInfo;
}
