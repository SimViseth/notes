package com.example.workspace.feature.workspace.service;

import com.example.workspace.app.response.BaseResponse;
import com.example.workspace.feature.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.feature.workspace.dto.response.WorkspaceResponse;

import java.util.List;

public interface WorkspaceService {
    BaseResponse<WorkspaceResponse> createWorkspace(WorkspaceRequest workspaceRequest);
    BaseResponse<List<WorkspaceResponse>> getAllWorkspaces();
    BaseResponse<WorkspaceResponse> getWorkspaceById(Integer workspaceId);
    BaseResponse<WorkspaceResponse> updateWorkspace(Integer workspaceId, WorkspaceRequest workspaceRequest);

}
