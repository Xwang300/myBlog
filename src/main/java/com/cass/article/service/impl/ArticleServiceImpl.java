package com.cass.article.service.impl;

import com.cass.article.domain.Article;
import com.cass.article.domain.ArticleType;
import com.cass.article.mapper.ArticleMapper;
import com.cass.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/11 15:36
 */
@Component
public class ArticleServiceImpl implements IArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleType> selectAllArticleType() {
        return articleMapper.selectAllTypes();
    }

    @Override
    public Integer insertArticleType(String name) {
        return articleMapper.insertArticleType(name);
    }

    @Override
    public Integer deleteTypeById(int id) {
        return articleMapper.deleteTypeById(id);
    }

    @Override
    public List<Article> selectAllArticle() {
        return articleMapper.selectAllArticle();
    }

    @Override
    public Integer deleteArticleById(Integer id) {
        return articleMapper.deleteArticleById(id);
    }

    @Override
    public Integer addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public Article selectArticleById(Integer id) {
        return articleMapper.selectArticleById(id);
    }

    @Override
    public Integer updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public List<Article> selectArticles() {
        return articleMapper.selectArticles();
    }

    @Override
    public Article selectArticleDetailById(Integer id) {
        return articleMapper.selectArticleDetailById(id);
    }

}
