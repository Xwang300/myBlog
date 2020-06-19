package com.cass.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Xin Wang
 * @Date 2020/6/12 11:11
 */

@AllArgsConstructor
public enum FruitEnum {

    APPLE(1,"苹果"),
    ORANGE(2,"橘子"),
    WATERMELON(3,"西瓜");

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
