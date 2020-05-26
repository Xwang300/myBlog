package com.cass.config.security;

import com.cass.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        //查询用户权限信息
        AuthUserDetails userInfo = (AuthUserDetails) userDetailService.loadUserByUsername(userName);
        if(userName==null){
            throw new UsernameNotFoundException("用户不存在！");
        }

        //密码判断
        String encodedPwd = MD5Utils.toMD5(password);
        if (!userInfo.getPassword().equals(encodedPwd)){
            throw new BadCredentialsException("密码错误！");
        }

        return new UsernamePasswordAuthenticationToken(userInfo,userInfo.getPassword(),userInfo.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
