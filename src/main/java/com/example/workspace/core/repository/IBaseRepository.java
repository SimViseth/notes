package com.example.workspace.core.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBaseRepository<T, ID> extends JpaRepository<T, ID> {

    // Insert
    public default T saveEntity(T entity) {
        T saveEntity = this.save(entity);
        return saveEntity;
    }

    // Get by Id
    public default Optional<T> getEntityById(ID id) {
        Optional<T> entity = this.findById(id);
        return entity;
    }

    // Update
    public default T updateEntity(T entity) {
        T updateEntity = this.save(entity);
        return updateEntity;
    }

    // Get all
    public default List<T> listAll(Sort sort) {
        List<T> entityList = this.findAll();
        return entityList;
    }

    // Delete
    public default boolean deleteEntity(ID id) {
        this.deleteById(id);
        return true;
    }

//    public default T saveEntity(T entity) {
//        T savedEntity = this.save(entity);
//        return savedEntity;
//    }
//
//    public default Optional<T> getEntityById(ID id) {
//        Optional<T> entity = this.findById(id);
//        return entity;
//    }
//
//    public default T updateEntity(T entity) {
//        T updatedEntity = this.save(entity);
//        return updatedEntity;
//    }
//
//    public default List<T> listAll(Sort sort) {
//        List<T> entityList = this.findAll(sort);
//        return entityList;
//    }
//    public default boolean deleteEntity(ID id) {
//        this.deleteById(id);
//        return true;
//    }
}

