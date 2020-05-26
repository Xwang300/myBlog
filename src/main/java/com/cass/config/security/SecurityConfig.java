package com.cass.config.security;

import com.alibaba.fastjson.JSON;
import com.cass.common.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SpringSecurityProvider provider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/blog/static/**");
    }

    /**
     * 配置资源访问权限
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().csrf().disable().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/login/loginSuccess")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler((HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e)-> {
                        BaseResponse<String> response = new BaseResponse<>();
                        e.printStackTrace();
                        response.setResMsg("您没有权限");
                        response.setResCode("1111");
                        httpServletResponse.setContentType("text/plain;charset=utf-8");
                        httpServletResponse.getWriter().write(JSON.toJSONString(response));

                }).authenticationEntryPoint((HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)->{
                        BaseResponse<String> response = new BaseResponse<>();
                        e.printStackTrace();
                        response.setResMsg("请先登录");
                        response.setResCode("1111");
                        httpServletResponse.setContentType("text/plain;charset=utf-8");
                        httpServletResponse.getWriter().write(JSON.toJSONString(response));
        });

        http.logout().logoutSuccessUrl("/login");
    }


    /**
     * 配置身份认证来源，用户及角色
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }
}
