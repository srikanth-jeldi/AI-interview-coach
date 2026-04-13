package com.epitomehub.mock_interview_service.repository;

import com.epitomehub.mock_interview_service.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = """
        SELECT q.* FROM questions q
         WHERE q.active = true
           AND q.technology_id IN (:technologyIds)
           AND q.question_type IN (:questionTypes)
           AND q.min_experience_years <= :experienceYears
           AND q.max_experience_years >= :experienceYears
           AND q.id NOT IN (:excludedIds)
           AND q.random_bucket BETWEEN :bucketStart AND :bucketEnd
         ORDER BY q.id
         LIMIT :candidateLimit
        """, nativeQuery = true)
    List<Question> findEligibleCandidates(
        @Param("technologyIds") List<Long> technologyIds,
        @Param("questionTypes") List<String> questionTypes,
        @Param("experienceYears") int experienceYears,
        @Param("excludedIds") List<Long> excludedIds,
        @Param("bucketStart") int bucketStart,
        @Param("bucketEnd") int bucketEnd,
        @Param("candidateLimit") int candidateLimit
    );
}
