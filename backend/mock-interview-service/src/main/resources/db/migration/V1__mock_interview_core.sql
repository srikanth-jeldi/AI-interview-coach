CREATE TABLE IF NOT EXISTS mock_interview_sessions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  status VARCHAR(32) NOT NULL,
  started_at TIMESTAMP NOT NULL,
  completed_at TIMESTAMP NULL,
  recycle_mode_enabled BOOLEAN NOT NULL DEFAULT FALSE,
  INDEX idx_mis_user_status (user_id, status)
);

CREATE TABLE IF NOT EXISTS mock_interview_session_questions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  session_id BIGINT NOT NULL,
  question_id BIGINT NOT NULL,
  display_order INT NOT NULL,
  UNIQUE KEY uq_session_question (session_id, question_id),
  INDEX idx_misq_session_order (session_id, display_order)
);

CREATE TABLE IF NOT EXISTS user_question_history (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  question_id BIGINT NOT NULL,
  last_outcome VARCHAR(32) NOT NULL,
  first_seen_at TIMESTAMP NOT NULL,
  last_seen_at TIMESTAMP NOT NULL,
  UNIQUE KEY uq_user_question (user_id, question_id),
  INDEX idx_uqh_user_outcome (user_id, last_outcome)
);
