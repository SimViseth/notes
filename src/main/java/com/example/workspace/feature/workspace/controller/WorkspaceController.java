package com.example.workspace.feature.workspace.controller;

import com.example.workspace.app.response.BaseResponse;
import com.example.workspace.feature.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.feature.workspace.dto.response.WorkspaceResponse;
import com.example.workspace.feature.workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/workspace")
@RequiredArgsConstructor
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @PostMapping("create")
    public BaseResponse<WorkspaceResponse> createWorkspace(@RequestBody WorkspaceRequest workspaceRequest) {
        BaseResponse<WorkspaceResponse> workspaceResponse = workspaceService.createWorkspace(workspaceRequest);
        return workspaceResponse;
    }

    @GetMapping("all")
    public BaseResponse<List<WorkspaceResponse>> getAllWorkspaces() {
        BaseResponse<List<WorkspaceResponse>> workspaceResponse = workspaceService.getAllWorkspaces();
        return workspaceResponse;
    }

    @GetMapping("/{workspaceId}")
    public BaseResponse<WorkspaceResponse> getWorkspaceById(@PathVariable Integer workspaceId) {
        BaseResponse<WorkspaceResponse> workspaceResponse = workspaceService.getWorkspaceById(workspaceId);
        return workspaceResponse;
    }
    @PutMapping("/{workspaceId}")
    public BaseResponse<WorkspaceResponse> getWorkspaceById(@PathVariable Integer workspaceId, @RequestBody WorkspaceRequest workspaceRequest) {
        BaseResponse<WorkspaceResponse> workspaceResponse = workspaceService.updateWorkspace(workspaceId, workspaceRequest);
        return workspaceResponse;
    }

    @DeleteMapping("/{workspaceId}")
    public BaseResponse<Void> deleteWorkspace(@PathVariable Integer workspaceId) {
        return workspaceService.deleteWorkspace(workspaceId);
    }
}