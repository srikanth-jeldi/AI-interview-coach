package com.epitomehub.mock_interview_service.controller;

import com.epitomehub.mock_interview_service.dto.CreateSessionRequest;
import com.epitomehub.mock_interview_service.dto.CreateSessionResponse;
import com.epitomehub.mock_interview_service.service.QuestionAllocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interviews")
@RequiredArgsConstructor
public class MockInterviewController {
    private final QuestionAllocationService allocationService;

    @PostMapping("/sessions")
    public CreateSessionResponse create(@Valid @RequestBody CreateSessionRequest request) {
        return allocationService.createSession(request);
    }
}
