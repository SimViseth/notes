package com.example.workspace.app.response;

import lombok.Getter;
import lombok.Setter;

import static com.example.workspace.app.constant.AppConstant.*;

@Getter
@Setter
public class BaseResponse <T> {
    String code = FAIL_CODE;
    String status = FAIL;
    String msgDev;
    T data;

    // helper
//    public BaseResponse<T> success(T data, String msg) {
//        BaseResponse<T> res = new BaseResponse<>();
//        res.setMsgDev(msg);
//        res.setData(data);
//        return res;
//    }
}
