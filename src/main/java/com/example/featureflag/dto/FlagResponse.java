package com.example.featureflag.dto;

import java.time.ZonedDateTime;

public record FlagResponse(
    Long id,
    Long projectId,
    String key,
    String description,
    String status,
    String environment,
    ZonedDateTime scheduledEnableAt,
    ZonedDateTime scheduledDisableAt,
    ZonedDateTime createdAt
) {}
