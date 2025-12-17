package com.example.workspace.controller;

import com.example.workspace.core.BaseResponse;
import com.example.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.dto.response.WorkspaceResponse;
import com.example.workspace.service.WorkspaceService;
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

    @PostMapping
    public BaseResponse<WorkspaceResponse> createWorkspace(@RequestBody WorkspaceRequest workspaceRequest) {
        BaseResponse<WorkspaceResponse> workspaceResponse = workspaceService.createWorkspace(workspaceRequest);
        return workspaceResponse;
    }

}
