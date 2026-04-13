package com.epitomehub.mock_interview_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "user_question_history",
    uniqueConstraints = @UniqueConstraint(name = "uq_user_question", columnNames = {"user_id", "question_id"}))
@Getter @Setter
public class UserQuestionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long questionId;

    @Column(nullable = false)
    private String lastOutcome;

    @Column(nullable = false)
    private Instant firstSeenAt;

    @Column(nullable = false)
    private Instant lastSeenAt;
}
