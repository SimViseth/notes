package com.example.workspace.feature.workspace.service.impl;

import com.example.workspace.core.dto.BaseEntityResponseDto;
import com.example.workspace.app.response.BaseResponse;
import com.example.workspace.feature.workspace.dao.WorkspaceDao;
import com.example.workspace.feature.workspace.dto.request.WorkspaceRequest;
import com.example.workspace.feature.workspace.dto.response.WorkspaceResponse;
import com.example.workspace.feature.workspace.entity.Workspace;
import com.example.workspace.feature.workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.workspace.app.constant.AppConstant.*;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImplement implements WorkspaceService {

    private final WorkspaceDao workspaceDao;
    @Override
    public BaseResponse<WorkspaceResponse> createWorkspace(WorkspaceRequest workspaceRequest) {

        // map request to entity
        Workspace workspace = new Workspace();
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
                .isPrivate(daoResponse.getEntity().getIsPrivate())
                .createdAt(daoResponse.getEntity().getCreatedAt())
                .updatedAt(daoResponse.getEntity().getUpdatedAt())
                .build();

        // final response
        BaseResponse<WorkspaceResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsgDev("Create workspace successfully");
        baseResponse.setData(workspaceResponse);

        return baseResponse;
    }

    @Override
    public BaseResponse<List<WorkspaceResponse>> getAllWorkspaces() {

        // call dao
        BaseEntityResponseDto<Workspace> daoResponse = workspaceDao.findAll();

        // map entity list to response list
        List<WorkspaceResponse> workspaceResponses = daoResponse.getEntityList()
                .stream()
                .map(workspace -> WorkspaceResponse.builder()
                        .workspaceId(workspace.getWorkspaceId())
                        .workspaceName(workspace.getWorkspaceName())
                        .isPrivate(workspace.getIsPrivate())
                        .createdAt(workspace.getCreatedAt())
                        .updatedAt(workspace.getUpdatedAt())
                        .build()
                )
                .toList();

        // final response
        BaseResponse<List<WorkspaceResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsgDev("Get workspace successfully");
        baseResponse.setData(workspaceResponses);

        return baseResponse;
    }

    @Override
    public BaseResponse<WorkspaceResponse> getWorkspaceById(Integer workspaceId) {

        // call dao
        BaseEntityResponseDto<Workspace> daoResponse = workspaceDao.findById(workspaceId);

        // handle not found
        if (FAIL.equals(daoResponse.getStatus())) {
            BaseResponse<WorkspaceResponse> response = new BaseResponse<>();
            response.setCode(daoResponse.getCode());
            response.setStatus(FAIL);
            response.setMsgDev("Workspace not found");
            response.setData(null);
            return response;
        }

        Workspace workspace = daoResponse.getEntity();

        // map entity -> response
        WorkspaceResponse workspaceResponse = WorkspaceResponse.builder()
                .workspaceId(workspace.getWorkspaceId())
                .workspaceName(workspace.getWorkspaceName())
                .isPrivate(workspace.getIsPrivate())
                .createdAt(workspace.getCreatedAt())
                .updatedAt(workspace.getUpdatedAt())
                .build();

        // success response
        BaseResponse<WorkspaceResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsgDev("Get workspace successfully");
        baseResponse.setData(workspaceResponse);

        return baseResponse;
    }

    @Override
    public BaseResponse<WorkspaceResponse> updateWorkspace(Integer workspaceId, WorkspaceRequest workspaceRequest) {
        // check exist or not
        BaseEntityResponseDto<Workspace> findResponse = workspaceDao.findById(workspaceId);
        if (FAIL.equals(findResponse.getStatus())) {
            BaseResponse<WorkspaceResponse> response = new BaseResponse<>();
            response.setCode(NOT_FOUND);
            response.setStatus(FAIL);
            response.setMsgDev("Workspace not found");
            return response;
        }

        Workspace workspace = findResponse.getEntity();

        // prepare field for update
        workspace.setWorkspaceName(workspaceRequest.getWorkspaceName());
        workspace.setIsPrivate(workspaceRequest.getIsPrivate());
        workspace.setUpdatedAt(LocalDateTime.now());

        // call dao
        BaseEntityResponseDto<Workspace> daoUpdateResponse = workspaceDao.update(workspace);
        Workspace update = daoUpdateResponse.getEntity();

        // map response
        WorkspaceResponse workspaceResponse = WorkspaceResponse.builder()
                .workspaceId(update.getWorkspaceId())
                .workspaceName(update.getWorkspaceName())
                .isPrivate(update.getIsPrivate())
                .createdAt(update.getCreatedAt())
                .updatedAt(update.getUpdatedAt())
                .build();

        BaseResponse<WorkspaceResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsgDev("Workspace updated successfully");
        baseResponse.setData(workspaceResponse);

        return baseResponse;
    }

    @Override
    public BaseResponse<Void> deleteWorkspace(Integer workspaceId) {
        // check
        BaseEntityResponseDto<Workspace> findResponse = workspaceDao.findById(workspaceId);
        if (FAIL.equals(findResponse.getStatus())) {
            BaseResponse<Void> response = new BaseResponse<>();
            response.setCode(NOT_FOUND);
            response.setStatus(FAIL);
            response.setMsgDev("Workspace not found");
            return response;
        }

        // call dao delete
        workspaceDao.deleteEntity(workspaceId);

        // final response
        BaseResponse<Void> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsgDev("Workspace deleted successfully");

        return baseResponse;
    }
}
