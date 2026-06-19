package com.example.featureflag.controller;

import com.example.featureflag.dto.CreateProjectRequest;
import com.example.featureflag.dto.ProjectResponse;
import com.example.featureflag.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // POST /api/v1/projects
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Returns 201 Created instead of 200 OK
    public ProjectResponse createProject(@Valid @RequestBody CreateProjectRequest request) {
        return projectService.createProject(request);
    }

    // GET /api/v1/projects
    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

    // GET /api/v1/projects/{id}
    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }
}
