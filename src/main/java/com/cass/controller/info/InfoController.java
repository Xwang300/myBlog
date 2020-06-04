package com.cass.controller.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/3 9:27
 */

@Controller
@RequestMapping("/info")
public class InfoController {


    @RequestMapping()
    public String info(){
        return "about";
    }

}
