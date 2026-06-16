package com.example.featureflag.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "flags")
@Getter
@Setter
@NoArgsConstructor
public class Flag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many Flags belong to One Project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "key", nullable = false)
    private String key;

    @Column
    private String description;

    @Column(nullable = false)
    private String status = "DISABLED";

    @Column(nullable = false)
    private String environment = "DEV";

    @Column(name = "scheduled_enable_at")
    private ZonedDateTime scheduledEnableAt;

    @Column(name = "scheduled_disable_at")
    private ZonedDateTime scheduledDisableAt;

    @Column(name = "created_at", insertable = false, updatable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private ZonedDateTime updatedAt;

    // A Flag has many Rules
    @OneToMany(mappedBy = "flag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rule> rules = new ArrayList<>();
}
