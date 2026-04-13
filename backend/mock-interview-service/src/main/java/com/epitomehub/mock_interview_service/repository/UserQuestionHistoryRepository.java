package com.epitomehub.mock_interview_service.repository;

import com.epitomehub.mock_interview_service.entity.UserQuestionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.LockModeType;
import java.util.List;

public interface UserQuestionHistoryRepository extends JpaRepository<UserQuestionHistory, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select h from UserQuestionHistory h where h.userId = :userId")
    List<UserQuestionHistory> lockAndFindAllByUserId(@Param("userId") Long userId);
}
