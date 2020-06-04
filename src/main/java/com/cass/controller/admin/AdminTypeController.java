package com.cass.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/4 15:32
 */

@Controller
@RequestMapping("/admin/type")
public class AdminTypeController {

    @RequestMapping("")
    public String typePage(){
        return "admin/types";
    }

    @RequestMapping("addTypePage")
    public String addTypePage(){
        return "admin/types-input";
    }

}
