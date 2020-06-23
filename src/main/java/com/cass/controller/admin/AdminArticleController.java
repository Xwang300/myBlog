package com.cass.controller.admin;

import com.cass.article.domain.Article;
import com.cass.article.domain.ArticleType;
import com.cass.article.service.IArticleService;
import com.cass.common.BaseConst;
import com.cass.common.BaseResponse;
import com.cass.elasticsearch.repository.ArticleRepository;
import com.cass.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/4 10:39
 */

@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {


    @Autowired
    private IArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping()
    public String articlePage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize, Model model){
//        List<ArticleType> articleTypes = articleService.selectAllArticleType();
//        model.addAttribute("articleTypes",articleTypes);
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleService.selectAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }


    @RequestMapping("/addArticlePage")
    public String addArticlePage(Model model){
        List<ArticleType> articleTypes = articleService.selectAllArticleType();
        model.addAttribute("articleTypes",articleTypes);
        return "admin/blogs-input";
    }


    @GetMapping("/deleteArticle")
    @ResponseBody
    public BaseResponse<String> deleteArticleById(@RequestParam("id") Integer id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        articleService.deleteArticleById(id);
        //删除ES中对应的数据
        articleRepository.deleteById(id);
        baseResponse.setResCode(BaseConst.SUCCESS_CODE);
        baseResponse.setResMsg("删除成功!");
        return baseResponse;
    }

    @PostMapping("/addArticle")
    @ResponseBody
    public BaseResponse<String> addArticle(@RequestBody Article article){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        articleService.addArticle(article);
        //如果不是保存草稿，则添加ES库
        if("1".equals(article.getDraft())){
            article.setCreateTime(DateUtil.getcurrentYMD());
            articleRepository.save(article);
        }
        baseResponse.setResCode(BaseConst.SUCCESS_CODE);
        baseResponse.setResMsg("添加成功");
        return baseResponse;
    }


    @RequestMapping("/editArticlePage")
    public String editArticlePage(Model model, @RequestParam("id") Integer id){
        List<ArticleType> articleTypes = articleService.selectAllArticleType();
        Article article = articleService.selectArticleById(id);
        model.addAttribute("article",article);
        model.addAttribute("articleTypes",articleTypes);
        return "admin/blogs-edit";
    }

    @PostMapping("/updateArticle")
    @ResponseBody
    public BaseResponse<String> updateArticle(@RequestBody Article article){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        //删除原来的条目
        articleRepository.deleteById(article.getId());
        //更新数据库
        articleService.updateArticle(article);
        //如果不是保存草稿，则添加ES库
        if("1".equals(article.getDraft())){
            article.setCreateTime(DateUtil.getcurrentYMD());
            articleRepository.save(article);
        }
        baseResponse.setResCode(BaseConst.SUCCESS_CODE);
        baseResponse.setResMsg("更新成功");
        return baseResponse;
    }

}
