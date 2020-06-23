package com.cass.controller.elasticsearch;

import com.cass.article.domain.Article;
import com.cass.elasticsearch.repository.ArticleRepository;
import com.cass.elasticsearch.repository.BlogRepository;
import com.cass.elasticsearch.domain.BlogModel;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/10 16:12
 */

@Controller
@RequestMapping("/search")
public class ElasticSearchController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @ResponseBody
    @PostMapping("/save")
    public BlogModel save(@RequestBody BlogModel blogModel){
        BlogModel save = blogRepository.save(blogModel);
        return save;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<BlogModel> selectAll(){
        Iterable<BlogModel> all = blogRepository.findAll();
        List<BlogModel> blogModels = new ArrayList<>();
        all.forEach(blogModels::add);
        return blogModels;
    }

    @GetMapping("/deleteById")
    @ResponseBody
    public String deleteById(Integer id){
        blogRepository.deleteById(id);
        return "success";
    }

    @GetMapping("/deleteIndex")
    @ResponseBody
    public String delete(){
        elasticsearchTemplate.deleteIndex("blog");
        return "success";
    }


    @ResponseBody
    @PostMapping("/searchByConditions")
    public List<BlogModel> searchByConditions(@RequestBody BlogModel blogModel){
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(blogModel.getTitle(),"title","remark");
        Iterable<BlogModel> search = blogRepository.search(queryBuilder);
        List<BlogModel> blogModels = new ArrayList<>();
        search.forEach(blogModels::add);
        return blogModels;
    }


    @RequestMapping("/searchPage")
    public String goSearchPage(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "20") int pageSize, Model model, @RequestParam("query") String query){
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(query,"title","description","content");
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Article> search = articleRepository.search(queryBuilder, pageable);
//        List<Article> articleList = new ArrayList<>();
//        search.forEach(articleList::add);
        model.addAttribute("query",query);
        model.addAttribute("page",search);
        model.addAttribute("currentPage",pageNum);
        return "search";
    }


}
