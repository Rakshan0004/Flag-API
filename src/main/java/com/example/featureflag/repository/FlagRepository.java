package com.example.featureflag.repository;

import com.example.featureflag.entity.Flag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlagRepository extends JpaRepository<Flag, Long> {
    
    // Spring Magic! It automatically writes the SQL: 
    // SELECT * FROM flags WHERE project_id = ? AND key = ?
    Optional<Flag> findByProjectIdAndKey(Long projectId, String key);
    
    List<Flag> findByProjectId(Long projectId);
}
