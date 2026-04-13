CREATE TABLE IF NOT EXISTS user_skills (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  technology_id BIGINT NOT NULL,
  proficiency VARCHAR(24) NOT NULL,
  target_level VARCHAR(24) NULL,
  UNIQUE KEY uq_user_skill (user_id, technology_id)
);
CREATE TABLE IF NOT EXISTS user_technology_progress (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  technology_id BIGINT NOT NULL,
  completion_pct DECIMAL(5,2) NOT NULL DEFAULT 0,
  strongest_area VARCHAR(120) NULL,
  weakest_area VARCHAR(120) NULL,
  UNIQUE KEY uq_user_tech_progress (user_id, technology_id)
);
