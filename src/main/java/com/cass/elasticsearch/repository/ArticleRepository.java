package com.cass.elasticsearch.repository;

import com.cass.article.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: Xin Wang
 * @Date 2020/6/22 14:52
 */

@Component
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {

}
