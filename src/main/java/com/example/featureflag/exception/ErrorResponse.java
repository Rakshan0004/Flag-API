package com.example.featureflag.exception;

import java.time.ZonedDateTime;

// Using a Java Record for DTOs is a great modern Java practice!
public record ErrorResponse(
    int status,
    String error,
    String message,
    ZonedDateTime timestamp
) {}
