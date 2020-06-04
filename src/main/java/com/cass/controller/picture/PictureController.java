package com.cass.controller.picture;

import com.cass.picture.domain.Picture;
import com.cass.picture.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 15:19
 */
@Controller
@RequestMapping("picture")
public class PictureController {

    @Autowired
    private IPictureService pictureService;

    @RequestMapping()
    public String picture(Model model){
        List<Picture> pictures = pictureService.selectAllPictures();
        model.addAttribute("pictureList",pictures);
        return "picture";
    }
}
