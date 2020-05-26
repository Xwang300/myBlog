package com.cass.controller.login;


import com.cass.common.BaseResponse;
import com.cass.config.security.AuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/loginSuccess")
    @ResponseBody
    public BaseResponse<AuthUserDetails> login(){
        BaseResponse<AuthUserDetails> response = new BaseResponse<>();
        AuthUserDetails details = (AuthUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.setResData(details);
        response.setResCode("0000");
        response.setResMsg("登录成功！");
        return response;
    }


    @RequestMapping()
    public String loginPage(){
        return "/login";
    }

    @RequestMapping("/redisTest")
    @ResponseBody
    public BaseResponse<String> redisTest(){
        redisTemplate.opsForValue().set("key","val");
        String key = (String)redisTemplate.opsForValue().get("key");
        BaseResponse<String> response = new BaseResponse<>();
        response.setResData(key);
        return response;
    }


}
