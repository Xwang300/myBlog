package com.cass.controller;

import com.cass.common.BaseResponse;
import com.cass.constant.FruitEnum;
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

    public static void main(String[] args) {
        byte a = (byte)1;
        Byte b = new Byte("1");
        System.out.println(a);
        if (1==1){
            System.out.println("111");
        }
    }
}
