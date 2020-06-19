package com.cass.elasticsearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.io.Serializable;

/**
 * @Author: Xin Wang
 * @Date 2020/6/5 16:52
 */

@Data
@Document(indexName = "blog",type = "BlogModel")
@Mapping(mappingPath = "/elasticsearch/es-blogmodel.json")
public class BlogModel implements Serializable {


    private static final long serialVersionUID = -2007517927010446409L;

    @Id
    private Integer id;

    private String title;

    private String remark;
}
