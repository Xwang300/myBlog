package com.cass.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@SpringBootApplication(scanBasePackages = {"com.cass.**"})
@EnableElasticsearchRepositories(basePackages = "com.cass.elasticsearch.repository")
@MapperScan(value = "com.cass.*.mapper")
public class BlogApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(BlogApplication.class, args);
    }

}
