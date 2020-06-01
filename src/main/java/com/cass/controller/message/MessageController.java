package com.cass.controller.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 15:47
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @RequestMapping()
    public String messagePage(){
        return "message";
    }
}
