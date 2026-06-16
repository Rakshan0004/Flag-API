package com.example.featureflag.repository;

import com.example.featureflag.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // JpaRepository automatically gives us save(), findById(), findAll(), deleteById(), etc!
}
