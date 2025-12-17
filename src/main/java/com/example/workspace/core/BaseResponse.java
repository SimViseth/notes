package com.example.workspace.core;

import lombok.Getter;
import lombok.Setter;

import static com.example.workspace.constant.NoteConstant.FAIL;
import static com.example.workspace.constant.NoteConstant.FAIL_CODE;

@Getter
@Setter
public class BaseResponse <T> {
    String code = FAIL_CODE;
    String status = FAIL;
    String msgDev;
    T entity;
}
