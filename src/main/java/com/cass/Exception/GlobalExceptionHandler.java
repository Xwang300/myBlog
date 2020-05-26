package com.cass.Exception;

import com.cass.common.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public BaseResponse<String> exceptionHandler(Exception e, HttpServletRequest request){
        BaseResponse<String> response = new BaseResponse<>();
        response.setResCode("1111");
        response.setResMsg(e.getMessage());
        response.setResData(request.getRequestURI());
        e.printStackTrace();
        return response;
    }
}
