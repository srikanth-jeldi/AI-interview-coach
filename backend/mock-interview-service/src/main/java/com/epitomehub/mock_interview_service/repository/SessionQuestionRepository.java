package com.epitomehub.mock_interview_service.repository;

import com.epitomehub.mock_interview_service.entity.MockInterviewSessionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionQuestionRepository extends JpaRepository<MockInterviewSessionQuestion, Long> {
    List<MockInterviewSessionQuestion> findBySessionId(Long sessionId);
}
