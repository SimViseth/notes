package com.example.workspace.core.dao;

import com.example.workspace.core.dto.BaseEntityResponseDto;

import java.util.List;

public interface IBaseDBDao<T, ID> {

    // Save
    BaseEntityResponseDto<T> saveEntity(T entity);

    // Save multi
    BaseEntityResponseDto<List<T>> saveEntities(List<T> entities);

    // Get by Id
    BaseEntityResponseDto<T> findById(ID id);

    // Update
    BaseEntityResponseDto<T> update(T entity);

    // Find All
    BaseEntityResponseDto<T> findAll();

    // Delete
    BaseEntityResponseDto<T> deleteEntity(ID id);
}
