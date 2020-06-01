package com.cass.controller.picture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 15:19
 */
@Controller
@RequestMapping("picture")
public class PictureController {

    @RequestMapping()
    public String picture(){
        return "picture";
    }
}
