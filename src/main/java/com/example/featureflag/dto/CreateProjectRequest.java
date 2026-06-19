package com.example.featureflag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProjectRequest(
    @NotBlank(message = "Project name cannot be empty")
    @Size(max = 100, message = "Project name cannot exceed 100 characters")
    String name,
    
    String description
) {}
