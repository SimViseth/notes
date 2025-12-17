package com.example.workspace.feature.workspace.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkspaceResponse {
    Integer workspaceId;
    String workspaceName;
    Boolean isPrivate;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
