package com.example.workspace.feature.workspace.dao;

import com.example.workspace.core.dao.BaseDBDao;
import com.example.workspace.feature.workspace.entity.Workspace;
import com.example.workspace.feature.workspace.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceDao extends BaseDBDao<Workspace, Integer> {
    //private WorkspaceRepository workspaceRepository;

    public WorkspaceDao(WorkspaceRepository workspaceRepository) {
        super(workspaceRepository);
        //this.workspaceRepository = workspaceRepository;
    }
}
