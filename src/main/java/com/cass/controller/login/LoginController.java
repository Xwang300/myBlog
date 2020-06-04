package com.cass.controller.login;


import com.cass.common.BaseConst;
import com.cass.common.BaseResponse;
import com.cass.config.security.AuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {


//    @Autowired
//    private RedisTemplate redisTemplate;

    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
//        BaseResponse<AuthUserDetails> response = new BaseResponse<>();
//        AuthUserDetails details = (AuthUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        response.setResData(details);
//        response.setResCode(BaseConst.SUCCESS_CODE);
//        response.setResMsg("登录成功！");
        return "admin/blogs";
    }

    @RequestMapping("loginFail")
    public String loginFail(Model model){
        model.addAttribute("fail",true);
        return "admin/login";
    }


    @RequestMapping()
    public String loginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() &&
            !(authentication instanceof AnonymousAuthenticationToken)){
            return "admin/blogs";
        }
        return "admin/login";
    }

    @RequestMapping("/noAuth")
    public String noAuth(Model model){
        model.addAttribute("noAuth","您没有权限访问！");
        model.addAttribute("fail",true);
        return "admin/login";
    }

    @RequestMapping("/noSignIn")
    public String noLogin(Model model){
        model.addAttribute("noAuth","请先登录！");
        model.addAttribute("fail",true);
        return "admin/login";
    }
//
//    @RequestMapping("/redisTest")
//    @ResponseBody
//    public BaseResponse<String> redisTest(){
//        redisTemplate.opsForValue().set("key","val");
//        String key = (String)redisTemplate.opsForValue().get("key");
//        BaseResponse<String> response = new BaseResponse<>();
//        response.setResData(key);
//        return response;
//    }


}
