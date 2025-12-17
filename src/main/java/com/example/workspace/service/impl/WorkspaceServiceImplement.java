package com.example.workspace.service.impl;

import com.example.workspace.core.BaseEntityResponseDto;
import com.example.workspace.core.BaseResponse;
import com.example.workspace.dao.WorkspaceDao;
import com.example.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.dto.response.WorkspaceResponse;
import com.example.workspace.entity.Workspace;
import com.example.workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.workspace.constant.NoteConstant.*;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImplement implements WorkspaceService {

    private final WorkspaceDao workspaceDao;
    @Override
    public BaseResponse<WorkspaceResponse> createWorkspace(WorkspaceRequest workspaceRequest) {

        // map request to entity
        var workspace = new Workspace();
        workspace.setWorkspaceName(workspaceRequest.getWorkspaceName());
        workspace.setIsPrivate(workspaceRequest.getIsPrivate());
        workspace.setCreatedAt(LocalDateTime.now());
        workspace.setUpdatedAt(LocalDateTime.now());

        // save call dao
        BaseEntityResponseDto<Workspace> daoResponse = workspaceDao.saveEntity(workspace);

        // map entity to response
        WorkspaceResponse workspaceResponse = WorkspaceResponse.builder()
                .workspaceId(daoResponse.getEntity().getWorkspaceId())
                .workspaceName(daoResponse.getEntity().getWorkspaceName())
                .createdAt(daoResponse.getEntity().getCreatedAt())
                .updatedAt(daoResponse.getEntity().getUpdatedAt())
                .build();

        // final response
        BaseResponse<WorkspaceResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setEntity(workspaceResponse);

        return baseResponse;

    }
}
