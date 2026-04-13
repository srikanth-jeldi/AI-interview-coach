CREATE TABLE IF NOT EXISTS technologies (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(120) NOT NULL UNIQUE,
  category VARCHAR(80) NOT NULL,
  active BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE IF NOT EXISTS subtopics (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  technology_id BIGINT NOT NULL,
  name VARCHAR(120) NOT NULL,
  UNIQUE KEY uq_subtopic (technology_id, name)
);
CREATE TABLE IF NOT EXISTS questions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  body TEXT NOT NULL,
  technology_id BIGINT NOT NULL,
  subtopic_id BIGINT NULL,
  category VARCHAR(80) NOT NULL,
  question_type VARCHAR(50) NOT NULL,
  difficulty VARCHAR(24) NOT NULL,
  min_experience_years INT NOT NULL,
  max_experience_years INT NOT NULL,
  company_style VARCHAR(80) NULL,
  random_bucket INT NOT NULL,
  active BOOLEAN NOT NULL DEFAULT TRUE,
  INDEX idx_question_filter (technology_id, question_type, difficulty, min_experience_years, max_experience_years, random_bucket)
);
CREATE TABLE IF NOT EXISTS question_options (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  question_id BIGINT NOT NULL,
  option_text VARCHAR(300) NOT NULL,
  is_correct BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE TABLE IF NOT EXISTS question_tags (
  question_id BIGINT NOT NULL,
  tag VARCHAR(60) NOT NULL,
  PRIMARY KEY (question_id, tag)
);
CREATE TABLE IF NOT EXISTS question_company_mapping (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  question_id BIGINT NOT NULL,
  company_name VARCHAR(120) NOT NULL,
  interview_round VARCHAR(80) NULL
);

INSERT INTO technologies (name, category) VALUES
('Java','Programming Languages'),('Python','Programming Languages'),('JavaScript','Programming Languages'),('TypeScript','Programming Languages'),
('Go','Programming Languages'),('C++','Programming Languages'),('C#','Programming Languages'),('Kotlin','Programming Languages'),
('Scala','Programming Languages'),('Rust','Programming Languages'),('PHP','Programming Languages'),('Spring Boot','Backend'),
('Node.js','Backend'),('Express','Backend'),('NestJS','Backend'),('.NET','Backend'),('Django','Backend'),('Flask','Backend'),
('React','Frontend'),('Angular','Frontend'),('Vue','Frontend'),('Next.js','Frontend'),('MySQL','Databases'),('PostgreSQL','Databases'),
('MongoDB','Databases'),('Redis','Databases'),('AWS','Cloud'),('Azure','Cloud'),('GCP','Cloud'),('Docker','DevOps'),('Kubernetes','DevOps'),
('Kafka','Messaging'),('RabbitMQ','Messaging'),('Microservices','Architecture'),('Distributed Systems','Architecture'),
('OAuth2','Security'),('JWT','Security'),('Spring Security','Security'),('JUnit','Testing'),('Mockito','Testing'),
('MLOps','Data / AI'),('Prompt Engineering','Data / AI'),('Git','General'),('Linux','General'),('Networking','General')
ON DUPLICATE KEY UPDATE name=name;
