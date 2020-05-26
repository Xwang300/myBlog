package com.cass.common;

import lombok.Data;

@Data
public class BaseResponse<T>{

    private String resCode;

    private String resMsg;

    private T resData;

}
