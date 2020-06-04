package com.cass.controller.admin;

import com.cass.picture.domain.Picture;
import com.cass.picture.service.IPictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/4 16:38
 */

@Controller
@RequestMapping("/admin/picture")
public class AdminPictureController {

    @Autowired
    private IPictureService pictureService;


    @RequestMapping()
    public String picturePage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize, Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<Picture> pictures = pictureService.selectAllPictures();
        PageInfo<Picture> pageInfo = new PageInfo<>(pictures);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }

    @RequestMapping("addPicturePage")
    public String addPicturePage(){
        return "admin/pictures-input";
    }

    @RequestMapping(value = "addPicture",method = RequestMethod.POST)
    public String addPicture(Model model, Picture picture){
        picture.toString();

        return "admin/pictures";
    }
}
