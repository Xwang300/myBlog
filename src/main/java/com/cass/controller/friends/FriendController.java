package com.cass.controller.friends;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 14:19
 */

@Controller
@RequestMapping("/friend")
public class FriendController {

    @RequestMapping()
    public String friendPage(){
        return "friends";
    }
}
