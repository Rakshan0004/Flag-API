package com.example.featureflag.dto;

import java.time.ZonedDateTime;

public record ProjectResponse(
    Long id,
    String name,
    String description,
    ZonedDateTime createdAt
) {}
