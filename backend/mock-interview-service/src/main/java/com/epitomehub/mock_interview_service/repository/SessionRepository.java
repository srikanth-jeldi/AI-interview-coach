package com.epitomehub.mock_interview_service.repository;

import com.epitomehub.mock_interview_service.entity.MockInterviewSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<MockInterviewSession, Long> {}
