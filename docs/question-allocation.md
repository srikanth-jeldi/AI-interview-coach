# Database Design for Unique Question Allocation

## Required Tables
- `questions` with indexed filter columns `(technology_id, question_type, difficulty, min_experience_years, max_experience_years, random_bucket)`
- `mock_interview_sessions`
- `mock_interview_session_questions` with unique `(session_id, question_id)`
- `user_question_history` with unique `(user_id, question_id)`

## Transaction-Safe Allocation Algorithm (No Repeats)
1. Begin transaction.
2. Lock `user_question_history` rows for target user (`PESSIMISTIC_WRITE`) to avoid race conditions from concurrent session starts.
3. Build exclusion set:
   - all `question_id` from history (answered/skipped/assigned depending policy)
   - all question IDs already assigned in current session
4. Query candidate questions with indexed filters:
   - technology set
   - question type mix
   - experience band
   - difficulty criteria
   - exclude IDs
   - bounded `random_bucket` window for low-cost randomization (avoid `ORDER BY RAND()`).
5. Allocate up to requested count and insert into `mock_interview_session_questions`.
6. Upsert `user_question_history` as `ASSIGNED` for each selected question.
7. If pool exhausted:
   - return exhausted flag OR
   - controlled recycle mode: rerun query with exclusion relaxed.
8. Commit.

This supports 50+ interviews without repeats for a user until pool exhaustion.
