package com.example.featureflag.dto;

public record EvaluationResponse(
    String key,
    boolean enabled
) {}
