package com.example.workspace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "TBL_WORKSPACE")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Workspace {
    @Id
    int workspaceId;
    String workspaceName;
    boolean isPrivate;
    Timestamp createdAt;
    Timestamp updatedAt;
}
