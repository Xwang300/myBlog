package com.cass.article.domain;

import lombok.Data;

/**
 * @Author: Xin Wang
 * @Date 2020/6/10 10:01
 */

@Data
public class Article {

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
