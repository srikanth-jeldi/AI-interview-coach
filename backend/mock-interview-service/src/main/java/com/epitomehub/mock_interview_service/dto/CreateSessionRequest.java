package com.epitomehub.mock_interview_service.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public record CreateSessionRequest(
    @NotNull Long userId,
    @NotEmpty List<Long> technologyIds,
    @Min(0) @Max(30) Integer experienceYears,
    @Pattern(regexp = "BEGINNER|INTERMEDIATE|ADVANCED") String targetDifficulty,
    @Min(5) @Max(20) Integer questionCount,
    @NotEmpty List<String> questionTypes,
    Boolean excludeSkippedQuestions,
    Boolean recycleOnExhaustion
) {}
