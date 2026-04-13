package com.epitomehub.mock_interview_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter @Setter
public class Question {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long technologyId;

    @Column(nullable = false)
    private String questionType;

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private Integer minExperienceYears;

    @Column(nullable = false)
    private Integer maxExperienceYears;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Integer randomBucket;
}
