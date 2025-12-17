package com.example.workspace.dto.response;

import com.example.workspace.core.BaseResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
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
