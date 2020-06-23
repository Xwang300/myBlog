package com.cass.controller.article;

import com.cass.article.domain.Article;
import com.cass.article.service.IArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 14:41
 */

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping()
    public String article(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleService.selectArticles();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        model.addAttribute("pageInfo",pageInfo);
        return "types";
    }

    @RequestMapping("/detail")
    public String articleDetail(Model model, @RequestParam("id") Integer id){
        Article article = articleService.selectArticleDetailById(id);
        model.addAttribute("article",article);
        return "blog";
    }
}
