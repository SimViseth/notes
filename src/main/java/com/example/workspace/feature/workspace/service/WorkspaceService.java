package com.example.workspace.feature.workspace.service;

import com.example.workspace.app.response.BaseResponse;
import com.example.workspace.feature.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.feature.workspace.dto.response.WorkspaceResponse;

public interface WorkspaceService {
    BaseResponse<WorkspaceResponse> createWorkspace(WorkspaceRequest workspaceRequest);
}
