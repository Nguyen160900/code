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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "study_app")
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StudyApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "registered_address")
    private String registeredAddress;

    @NonNull
    @Column(name = "current_address")
    private String currentAddress;

    @NonNull
    @Column(name = "citizen_identification")
    private String citizenIdentification;

    @NonNull
    @Column(name = "date_issue")
    private LocalDate dateIssue;

    @NonNull
    @Column(name = "place_issue")
    private String placeIssue;

    @NonNull
    @Column(name = "number_driver_license")
    private String numberDriverLicense;

    @NonNull
    @Column(name = "date_issue_driver")
    private LocalDate dateIssueDriver;

    @NonNull
    @Column(name = "level_name")
    private String levelName;

    @NonNull
    @Column(name = "ageney")
    private String ageney;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "status_apply_integration")
    private Boolean statusApplyIntegration;

    @NonNull
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @NonNull
    @Type(type = "text")
    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_test_id", referencedColumnName = "id")
    private UserTest userTest;
}
