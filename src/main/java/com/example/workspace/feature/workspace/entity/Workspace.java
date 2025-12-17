package com.example.workspace.feature.workspace.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_WORKSPACE")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer workspaceId;
    String workspaceName;
    Boolean isPrivate;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
