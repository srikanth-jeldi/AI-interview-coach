# EpitomeHub Technologies — AI Interview Coach

Production-grade full-stack monorepo for a microservices-based AI Interview Coach platform.

## Stack
- **Frontend**: React 19 + TypeScript + Vite + Tailwind + shadcn/ui + Framer Motion + Recharts
- **Backend**: Java 21, Spring Boot 3.3, Spring Cloud Gateway, JWT, MySQL, Redis, Kafka, Flyway
- **Infra**: Docker Compose for local orchestration

## Monorepo Structure
- `frontend/` premium responsive web app
- `backend/` Spring Boot microservices
- `docs/` architecture, API contracts, allocation algorithm notes
- `scripts/` local setup helpers

## Quick Start
```bash
cp .env.example .env
./scripts/bootstrap.sh
```

## Core Guarantees
- Question non-repetition per user until eligible pool exhaustion
- Transaction-safe allocation using row-level locking and user history checks
- Difficulty/type/technology-aware interview generation
- Seed technology coverage across full IT ecosystem

## Services
1. `api-gateway` — edge, auth routing, request tracing
2. `auth-service` — login/register/refresh/reset
3. `user-profile-service` — profile, skills, progress preferences
4. `question-service` — question catalog, taxonomy, admin content APIs
5. `mock-interview-service` — session creation, unique allocation, scoring, reports
6. `analytics-service` — trends, strengths/weaknesses, recommendations
7. `job-service` — role mappings, skill gap, saved jobs, roadmaps
8. `notification-service` — user/admin notifications

## Build
```bash
# frontend
cd frontend && npm install && npm run dev

# backend example
cd backend/mock-interview-service && ./mvnw spring-boot:run
```

## Production Notes
- Use managed MySQL, Redis, Kafka in non-local environments
- Configure Vault/Secrets Manager for JWT + DB secrets
- Enable Micrometer + OpenTelemetry exporters
