CREATE TABLE IF NOT EXISTS job_roles (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(160) NOT NULL,
  experience_band VARCHAR(40) NOT NULL,
  description TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS job_role_skills (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  job_role_id BIGINT NOT NULL,
  technology_id BIGINT NOT NULL,
  importance_weight INT NOT NULL,
  UNIQUE KEY uq_job_role_skill (job_role_id, technology_id)
);
CREATE TABLE IF NOT EXISTS saved_jobs (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  job_role_id BIGINT NOT NULL,
  target_company VARCHAR(160) NULL,
  saved_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uq_saved_job (user_id, job_role_id)
);
