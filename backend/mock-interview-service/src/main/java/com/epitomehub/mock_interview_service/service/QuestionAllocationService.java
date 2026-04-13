package com.epitomehub.mock_interview_service.service;

import com.epitomehub.mock_interview_service.dto.CreateSessionRequest;
import com.epitomehub.mock_interview_service.dto.CreateSessionResponse;
import com.epitomehub.mock_interview_service.dto.SessionQuestionDto;
import com.epitomehub.mock_interview_service.entity.*;
import com.epitomehub.mock_interview_service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionAllocationService {
    private final SessionRepository sessionRepository;
    private final SessionQuestionRepository sessionQuestionRepository;
    private final UserQuestionHistoryRepository historyRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    public CreateSessionResponse createSession(CreateSessionRequest request) {
        List<UserQuestionHistory> lockedHistory = historyRepository.lockAndFindAllByUserId(request.userId());

        MockInterviewSession session = new MockInterviewSession();
        session.setUserId(request.userId());
        session.setStatus("ACTIVE");
        session.setStartedAt(Instant.now());
        session.setRecycleModeEnabled(Boolean.TRUE.equals(request.recycleOnExhaustion()));
        session = sessionRepository.save(session);

        Set<Long> excluded = lockedHistory.stream().map(UserQuestionHistory::getQuestionId).collect(Collectors.toSet());
        List<Long> excludedList = excluded.isEmpty() ? List.of(-1L) : new ArrayList<>(excluded);

        int bucket = ThreadLocalRandom.current().nextInt(0, 900);
        List<Question> candidates = questionRepository.findEligibleCandidates(
            request.technologyIds(),
            request.questionTypes(),
            request.experienceYears(),
            excludedList,
            bucket,
            bucket + 99,
            request.questionCount() * 5
        );

        if (candidates.size() < request.questionCount() && Boolean.TRUE.equals(request.recycleOnExhaustion())) {
            candidates = questionRepository.findEligibleCandidates(
                request.technologyIds(),
                request.questionTypes(),
                request.experienceYears(),
                List.of(-1L),
                0,
                999,
                request.questionCount() * 5
            );
        }

        List<Question> selected = candidates.stream().limit(request.questionCount()).toList();
        List<SessionQuestionDto> assigned = new ArrayList<>();

        for (int i = 0; i < selected.size(); i++) {
            Question q = selected.get(i);

            MockInterviewSessionQuestion sq = new MockInterviewSessionQuestion();
            sq.setSessionId(session.getId());
            sq.setQuestionId(q.getId());
            sq.setDisplayOrder(i + 1);
            sessionQuestionRepository.save(sq);

            UserQuestionHistory h = new UserQuestionHistory();
            h.setUserId(request.userId());
            h.setQuestionId(q.getId());
            h.setLastOutcome("ASSIGNED");
            h.setFirstSeenAt(Instant.now());
            h.setLastSeenAt(Instant.now());
            historyRepository.save(h);

            assigned.add(new SessionQuestionDto(q.getId(), i + 1));
        }

        boolean exhausted = assigned.size() < request.questionCount();
        return new CreateSessionResponse(session.getId(), "ACTIVE", exhausted, assigned);
    }
}
