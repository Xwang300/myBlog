package com.cass.controller.article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 14:41
 */

@Controller
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping()
    public String article(){
        return "types";
    }
}
