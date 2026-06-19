package com.example.featureflag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateRuleRequest(
    @NotBlank(message = "Type is required")
    String type,
    
    @NotBlank(message = "Value is required")
    String value,
    
    @NotNull(message = "Priority is required")
    Integer priority
) {}
