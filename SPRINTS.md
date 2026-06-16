# Feature Flag API - Sprint Plan

This document outlines the end-to-end sprint plan for building the Feature Flag API using Java 21, Spring Boot 3, PostgreSQL, and Redis. 

## Sprint 1: Project Setup & Data Foundation
**Goal**: Initialize the application, configure the databases, and map out the core domain entities.

- [x] **Task 1.1**: Initialize Spring Boot Project (Web, Data JPA, Validation, Postgres, Redis).
- [x] **Task 1.2**: Setup Local Infrastructure (`docker-compose.yml` for Postgres and Redis).
- [x] **Task 1.3**: Configure Flyway for Database Migrations (initial schema).
- [x] **Task 1.4**: Create JPA Entities (`Project`, `Flag`, `Rule`, `AuditLog`) with relationships.
- [ ] **Task 1.5**: Configure Spring Data JPA Repositories.
- [ ] **Task 1.6**: Setup Global Exception Handling (`@ControllerAdvice`).

## Sprint 2: Core Management APIs (Projects & Flags)
**Goal**: Build the CRUD endpoints to manage Projects and Feature Flags.

- **Task 2.1**: Implement DTOs using Java Records.
- **Task 2.2**: Implement Project Service and Controller.
- **Task 2.3**: Implement Flag Service and Controller (POST, GET, PATCH toggle, DELETE).
- **Task 2.4**: Unit Tests for Service and Controllers (JUnit 5, Mockito).

## Sprint 3: Rule Targeting Engine & Caching
**Goal**: Allow adding targeting rules to flags and implement the high-performance evaluation engine.

- **Task 3.1**: Implement Rule Management Endpoints (Add/Delete rules per flag).
- **Task 3.2**: Build the Evaluation Engine.
  - Implement logic for `USER_ID`, `ATTRIBUTE`, and `PERCENTAGE` rules.
  - Use Consistent Hashing (e.g., MurmurHash3) for percentage rollouts.
- **Task 3.3**: Integrate Redis Caching for evaluation lookups.
- **Task 3.4**: Test Evaluation Logic comprehensively.

## Sprint 4: Scheduling & Audit Logging
**Goal**: Support scheduled flag rollouts and track all changes for compliance/debugging.

- **Task 4.1**: Implement Flag Schedulers (`@Scheduled` to process `scheduledEnableAt` / `scheduledDisableAt`).
- **Task 4.2**: Implement Audit Logging (recording changes to flags and rules).
- **Task 4.3**: Expose Audit Endpoints to fetch history.
- **Task 4.4**: Integration testing with Testcontainers (Postgres + Redis).

## Sprint 5: Security & Documentation
**Goal**: Secure the API using API Keys and provide swagger documentation for consumers.

- **Task 5.1**: API Key Authentication (Spring Security filter).
- **Task 5.2**: Apply Method Level Security (restricting access per project).
- **Task 5.3**: API Documentation (`springdoc-openapi` / Swagger).
- **Task 5.4**: Final Polish, Code Review, and End-to-End Testing.
