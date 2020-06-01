package com.cass.controller.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: Xin Wang
 * @Date 2020/6/1 10:09
 */


@Controller
public class HomePageController {

    @RequestMapping("/home")
    public String homePage(){
        return "index";
    }

}
