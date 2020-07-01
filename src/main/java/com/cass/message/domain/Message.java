package com.cass.message.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Xin Wang
 * @Date 2020/7/1 16:23
 */

@Data
public class Message {

    private Integer id;

    private String name;

    private String content;

    private Date createTime;

}
