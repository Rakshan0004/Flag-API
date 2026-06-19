package com.example.featureflag.service;

import com.example.featureflag.dto.CreateProjectRequest;
import com.example.featureflag.dto.ProjectResponse;
import com.example.featureflag.entity.Project;
import com.example.featureflag.exception.ResourceNotFoundException;
import com.example.featureflag.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Lombok magic: creates a constructor for all 'final' fields (Dependency Injection!)
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectResponse createProject(CreateProjectRequest request) {
        // 1. Convert DTO (Request) -> Entity
        Project project = new Project();
        project.setName(request.name());
        project.setDescription(request.description());
        
        // 2. Save Entity to Database
        Project savedProject = projectRepository.save(project);
        
        // 3. Convert Entity -> DTO (Response)
        return mapToResponse(savedProject);
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project with ID " + id + " not found"));
        return mapToResponse(project);
    }

    // Helper method to convert an Entity into a DTO View
    private ProjectResponse mapToResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getCreatedAt()
        );
    }
}
