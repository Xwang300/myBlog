package com.cass.article.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.io.Serializable;

/**
 * @Author: Xin Wang
 * @Date 2020/6/10 10:01
 */

@Data
@Document(indexName = "articles",type = "Article")
@Mapping(mappingPath = "/elasticsearch/es-article.json")
public class Article implements Serializable {

    private static final long serialVersionUID = 1235839068726207926L;

    @Id
    private Integer id;

    private String title;

    private String articleType;

    private String type;

    private String draft;

    private String content;

    private String createTime;

    private String picture;

    private String description;

}
