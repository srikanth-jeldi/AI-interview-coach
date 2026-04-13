INSERT INTO questions (
  title, body, technology_id, category, question_type, difficulty, min_experience_years, max_experience_years, company_style, random_bucket, active
) VALUES
('Explain Java memory model visibility guarantees', 'Discuss happens-before and volatile behavior with practical production examples.', 1, 'Core Java', 'THEORY', 'INTERMEDIATE', 2, 8, 'MNC', 101, true),
('Debug a high-latency REST endpoint in Spring Boot', 'Walk through diagnostics and fixes including DB, thread pool, and caching angles.', 12, 'Backend', 'DEBUGGING', 'ADVANCED', 4, 12, 'Product', 202, true),
('Design event-driven order pipeline', 'Design microservices with idempotency, retries, and exactly-once trade-offs.', 34, 'Architecture', 'ARCHITECTURE', 'ADVANCED', 5, 15, 'FAANG', 303, true),
('Resolve Kafka consumer lag during incidents', 'Describe triage plan, tooling, and remediation with minimal data loss.', 32, 'Messaging', 'PRODUCTION_INCIDENT', 'ADVANCED', 3, 15, 'MNC', 404, true),
('Behavioral: handling conflicting priorities', 'Demonstrate ownership, communication, and decision-making under pressure.', 43, 'General', 'BEHAVIORAL', 'BEGINNER', 0, 30, 'Universal', 505, true)
ON DUPLICATE KEY UPDATE title=VALUES(title);
