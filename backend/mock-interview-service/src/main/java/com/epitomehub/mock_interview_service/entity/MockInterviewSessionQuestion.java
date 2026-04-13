package com.epitomehub.mock_interview_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mock_interview_session_questions",
    uniqueConstraints = @UniqueConstraint(name = "uq_session_question", columnNames = {"session_id", "question_id"}))
@Getter @Setter
public class MockInterviewSessionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long sessionId;

    @Column(nullable = false)
    private Long questionId;

    @Column(nullable = false)
    private Integer displayOrder;
}
