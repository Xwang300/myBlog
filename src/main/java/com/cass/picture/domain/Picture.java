package com.cass.picture.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Xin Wang
 * @Date 2020/6/3 10:38
 */

@Data
public class Picture {

    private Integer id;

    private String name;

    private String place;

    private Date createTime;

    private String description;

    private String url;
}
