package com.example.workspace.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkspaceRequest {
    String workspaceName;
    Boolean isPrivate;
    Timestamp createdAt;
    Timestamp updatedAt;
}
