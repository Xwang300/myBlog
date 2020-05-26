package com.cass.controller;

import com.cass.common.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @RequestMapping("/world")
    public BaseResponse<String> helloWorld(){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        baseResponse.setResData("hello world");
        return baseResponse;
    }
}
