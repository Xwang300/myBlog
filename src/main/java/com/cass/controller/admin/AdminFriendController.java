package com.cass.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/4 16:13
 */

@Controller
@RequestMapping("/admin/friend")
public class AdminFriendController {

    @RequestMapping("")
    public String friendPage(){
        return "admin/friendlinks";
    }

    @RequestMapping("/addFriendPage")
    public String addFriendPage(){
        return "admin/friendlinks-input";
    }
}
