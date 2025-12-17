package com.example.workspace.service;

import com.example.workspace.core.BaseResponse;
import com.example.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.dto.response.WorkspaceResponse;

public interface WorkspaceService {
    BaseResponse<WorkspaceResponse> createWorkspace(WorkspaceRequest workspaceRequest);
}
