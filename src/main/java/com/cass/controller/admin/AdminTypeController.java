package com.cass.controller.admin;

import com.cass.article.domain.ArticleType;
import com.cass.article.service.IArticleService;
import com.cass.common.BaseConst;
import com.cass.common.BaseResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/4 15:32
 */

@Controller
@RequestMapping("/admin/type")
public class AdminTypeController {


    @Autowired
    private IArticleService articleService;

    @RequestMapping("")
    public String typePage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize, Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleType> articleTypes = articleService.selectAllArticleType();
        PageInfo<ArticleType> pageInfo = new PageInfo<>(articleTypes);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/types";
    }

    @RequestMapping("/addTypePage")
    public String addTypePage(){
        return "admin/types-input";
    }

    @GetMapping("/addType")
    public String addArticleType(String name){
        articleService.insertArticleType(name);
        return "admin/types-input";
    }


    @RequestMapping(value = "/deleteType",method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<String> deleteType(@RequestParam("id") int id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        articleService.deleteTypeById(id);
        baseResponse.setResCode(BaseConst.SUCCESS_CODE);
        baseResponse.setResMsg("删除成功!");
        return baseResponse;
    }
}
