package com.cass.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication(scanBasePackages = {"com.cass.**"})
@MapperScan(value = "com.cass.*.mapper")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }


    @RequestMapping()
    public String goHomePage(){
        return "index";
    }
}
