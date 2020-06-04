package com.cass.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/4 10:39
 */

@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {


    @RequestMapping()
    public String articlePage(){
        return "admin/blogs";
    }


    @RequestMapping("/addArticlePage")
    public String addArticlePage(){
        return "admin/blogs-input";
    }
}
