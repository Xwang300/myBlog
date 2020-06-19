package com.cass.article.mapper;

import com.cass.article.domain.Article;
import com.cass.article.domain.ArticleType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/10 10:02
 */

@Component
public interface ArticleMapper {

    List<ArticleType> selectAllTypes();

    Integer insertArticleType(String name);

    Integer deleteTypeById(int id);

    List<Article> selectAllArticle();

    Integer deleteArticleById(Integer id);

    Integer addArticle(Article article);

    Article selectArticleById(Integer id);

    Integer updateArticle(Article article);
}
