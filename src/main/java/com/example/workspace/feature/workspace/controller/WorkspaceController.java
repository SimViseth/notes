package com.example.workspace.feature.workspace.controller;

import com.example.workspace.app.response.BaseResponse;
import com.example.workspace.feature.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.feature.workspace.dto.response.WorkspaceResponse;
import com.example.workspace.feature.workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}