package com.example.workspace.core;

import java.util.Optional;

import static com.example.workspace.constant.NoteConstant.*;

public abstract class BaseDBDao<T, ID> implements IBaseDBDao<T, ID> {

    protected IBaseRepository<T, ID> repository;

    public BaseDBDao(IBaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public BaseEntityResponseDto<T> saveEntity(T entity) {
        String currentMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        long startTime = System.currentTimeMillis();

        T savedEntity = repository.saveEntity(entity);

        var entityDto = new BaseEntityResponseDto<T>();
        entityDto.setStatus(SUCCESS);
        entityDto.setEntity(savedEntity);
        return entityDto;

    }

    @Override
    public BaseEntityResponseDto<T> findById(ID id) {
        String currentMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        long startTime = System.currentTimeMillis();
        String responseStatus = SUCCESS;

        Optional<T> optionalEntity = repository.getEntityById(id);
        if (!optionalEntity.isPresent()) {
            responseStatus = FAIL;
        }
        T entity = optionalEntity.orElseGet(() -> null);

        var entityDto = new BaseEntityResponseDto<T>();
        entityDto.setCode(optionalEntity.isPresent() ? SUCCESS_CODE : NOT_FOUND);
        entityDto.setStatus(responseStatus);
        entityDto.setEntity(entity);
        return entityDto;
    }

    @Override
    public BaseEntityResponseDto<T> update(T entity) {
        String currentMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        long startTime = System.currentTimeMillis();

        T updatedEntity = repository.updateEntity(entity);

        var entityDto = new BaseEntityResponseDto<T>();
        entityDto.setStatus(SUCCESS);
        entityDto.setEntity(updatedEntity);
        return entityDto;
    }
}