package com.epitomehub.mock_interview_service.dto;

import java.util.List;

public record CreateSessionResponse(Long sessionId, String status, Boolean exhausted, List<SessionQuestionDto> questions) {}
