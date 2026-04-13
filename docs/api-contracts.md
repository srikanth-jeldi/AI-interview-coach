# API Contracts (Core)

## Auth
- `POST /api/auth/register`
- `POST /api/auth/login`
- `POST /api/auth/refresh`
- `POST /api/auth/reset-password/request`

## Technologies & Questions
- `GET /api/technologies`
- `GET /api/questions`
- `GET /api/questions/{id}`
- `POST /api/admin/questions`
- `PUT /api/admin/questions/{id}`
- `DELETE /api/admin/questions/{id}`

## Mock Interviews
- `POST /api/interviews/sessions` (unique allocation)
- `POST /api/interviews/sessions/{id}/answers`
- `POST /api/interviews/sessions/{id}/complete`
- `GET /api/interviews/sessions/{id}/report`

## Analytics
- `GET /api/analytics/dashboard`
- `GET /api/analytics/technologies/weakness`

## Jobs
- `GET /api/jobs/roles`
- `GET /api/jobs/roles/{id}/gap-analysis`
- `POST /api/jobs/saved`
