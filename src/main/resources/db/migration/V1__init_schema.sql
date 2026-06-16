-- V1__init_schema.sql
-- We are using PostgreSQL, so this script uses PostgreSQL-specific syntax
-- (like BIGSERIAL for auto-incrementing IDs and TIMESTAMP WITH TIME ZONE).

CREATE TABLE projects (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE flags (
    id BIGSERIAL PRIMARY KEY,
    project_id BIGINT NOT NULL,
    key VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL DEFAULT 'DISABLED',
    environment VARCHAR(50) NOT NULL DEFAULT 'DEV',
    scheduled_enable_at TIMESTAMP WITH TIME ZONE,
    scheduled_disable_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
    CONSTRAINT unique_project_flag_key UNIQUE (project_id, key)
);

CREATE TABLE rules (
    id BIGSERIAL PRIMARY KEY,
    flag_id BIGINT NOT NULL,
    type VARCHAR(50) NOT NULL,
    value VARCHAR(255) NOT NULL,
    priority INT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_flag FOREIGN KEY (flag_id) REFERENCES flags (id) ON DELETE CASCADE
);

CREATE TABLE audit_logs (
    id BIGSERIAL PRIMARY KEY,
    flag_id BIGINT NOT NULL,
    changed_by VARCHAR(255) NOT NULL,
    change_type VARCHAR(100) NOT NULL,
    previous_value TEXT,
    new_value TEXT,
    changed_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_audit_flag FOREIGN KEY (flag_id) REFERENCES flags (id) ON DELETE CASCADE
);
