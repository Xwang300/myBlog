package com.cass.user.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String nickName;

    private String email;

    private String password;

    private Date createTime;

    private Date lastLoginTime;

    private String status;
}
