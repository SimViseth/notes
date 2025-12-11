package com.example.workspace.core;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IBaseDBDao<T, ID> {

    BaseEntityResponseDto<T> saveEntity(T entity);

    CompletableFuture<BaseEntityResponseDto<T>> saveEntityAsync(T entity);

    BaseEntityResponseDto<List<T>> saveEntities(List<T> entities);

    CompletableFuture<BaseEntityResponseDto<List<T>>> saveEntitiesAsync(List<T> entities);

    BaseEntityResponseDto<T> findById(ID id);

    CompletableFuture<BaseEntityResponseDto<T>> getEntityByIdAsync(ID id);

    BaseEntityResponseDto<T> update(T entity);

    CompletableFuture<BaseEntityResponseDto<T>> updateAsync(T entity);

    BaseEntityResponseDto<T> findAllWithSortBy(String sortBy, String sortDirection);

    CompletableFuture<BaseEntityResponseDto<T>> listAllAsync(String sortBy, String sortDirection);

    BaseEntityResponseDto<T> findAll();

    CompletableFuture<BaseEntityResponseDto<T>> findAllAsync();

    BaseEntityResponseDto<T> deleteEntity(ID id);
}
