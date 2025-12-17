package com.example.workspace.dao;

import com.example.workspace.core.BaseDBDao;
import com.example.workspace.entity.Workspace;
import com.example.workspace.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceDao extends BaseDBDao<Workspace, Integer> {
    //private WorkspaceRepository workspaceRepository;

    public WorkspaceDao(WorkspaceRepository workspaceRepository) {
        super(workspaceRepository);
        //this.workspaceRepository = workspaceRepository;
    }
}
