package com.example.featureflag.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

public record CreateFlagRequest(
    @NotBlank(message = "Flag key cannot be empty")
    String key,
    
    String description,
    String status,
    String environment,
    ZonedDateTime scheduledEnableAt,
    ZonedDateTime scheduledDisableAt
) {}
