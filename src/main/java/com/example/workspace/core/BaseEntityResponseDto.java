package com.example.workspace.core;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.example.workspace.constant.NoteConstant.FAIL;
import static com.example.workspace.constant.NoteConstant.FAIL_CODE;

@Getter
@Setter
public class BaseEntityResponseDto<T> {
    String code = FAIL_CODE;
    String status = FAIL;
    T entity;
    List<T> entityList;
}