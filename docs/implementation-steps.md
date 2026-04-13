# Codebase Generation Steps
1. Bootstrap monorepo and local infrastructure (`docker-compose.yml`, `.env.example`, `scripts/bootstrap.sh`).
2. Scaffold frontend React+TS+Vite with Tailwind and routed feature modules.
3. Scaffold 8 Spring Boot microservices with baseline production dependencies.
4. Add Flyway migrations for core domain entities and indexes.
5. Implement question-service catalog APIs backed by DB tables.
6. Implement mock-interview unique question allocation flow with transaction safety and exclusion logic.
7. Add architecture docs and API contract docs.
8. Extend each service with domain-specific business logic, auth hardening, and async Kafka workflows.
