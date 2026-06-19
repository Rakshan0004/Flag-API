package com.example.featureflag.dto;

public record RuleResponse(
    Long id,
    Long flagId,
    String type,
    String value,
    Integer priority
) {}
