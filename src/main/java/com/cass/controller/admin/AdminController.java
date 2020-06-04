package com.cass.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/4 11:25
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping()
    public String adminPage(){
        return "admin/blogs";
    }



}
