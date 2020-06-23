package com.cass.article.service;

import com.cass.article.domain.Article;
import com.cass.article.domain.ArticleType;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/11 15:36
 */
public interface IArticleService {

    List<ArticleType> selectAllArticleType();

    Integer insertArticleType(String name);

    Integer deleteTypeById(int id);

    List<Article> selectAllArticle();

    Integer deleteArticleById(Integer id);

    Integer addArticle(Article article);

    Article selectArticleById(Integer id);

    Integer updateArticle(Article article);

    List<Article> selectArticles();

    Article selectArticleDetailById(Integer id);
}
