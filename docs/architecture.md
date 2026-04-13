# Final Architecture and Folder Structure

## Why React + Vite
Vite is selected for fast iteration, smaller operational overhead for SPA dashboard/product UI, and clean TypeScript support. Next.js SSR is not mandatory for authenticated app-heavy flows.

## Monorepo Tree
```text
.
├── frontend/
├── backend/
│   ├── api-gateway/
│   ├── auth-service/
│   ├── user-profile-service/
│   ├── question-service/
│   ├── mock-interview-service/
│   ├── analytics-service/
│   ├── job-service/
│   └── notification-service/
├── docs/
└── scripts/
```

## Backend Service Responsibilities
- **api-gateway**: edge routing, auth propagation, rate limiting extension point.
- **auth-service**: users, roles, credentials, JWT + refresh lifecycle.
- **user-profile-service**: user skill profile and progress.
- **question-service**: technologies, taxonomy, questions, tags, company mapping, admin content.
- **mock-interview-service**: create sessions, allocate unique questions, capture answers, scoring pipelines.
- **analytics-service**: score trends, weak topics, recommendations, reporting.
- **job-service**: role-based prep, skill gaps, saved roles/jobs.
- **notification-service**: in-app notifications + async dispatch hooks.

## Frontend App Structure
- `src/app`: router + app shell
- `src/features/*`: domain feature slices (dashboard, questions, mock, jobs, admin, auth)
- `src/lib`: API and utilities
- `src/components`: reusable shared components
- `src/styles`: global theme/tokens
