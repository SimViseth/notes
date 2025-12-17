package com.example.workspace.app.response;

import lombok.Getter;
import lombok.Setter;

import static com.example.workspace.app.constant.AppConstant.FAIL;
import static com.example.workspace.app.constant.AppConstant.FAIL_CODE;

@Getter
@Setter
public class BaseResponse <T> {
    String code = FAIL_CODE;
    String status = FAIL;
    String msgDev;
    T entity;
}
