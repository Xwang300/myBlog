package com.cass.config.security;

import com.cass.user.domain.Permission;
import com.cass.user.domain.Role;
import com.cass.user.domain.User;
import com.cass.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserService implements UserDetailsService {


    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserName(userName);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<Role> roleList = userService.findRoleListByUserId(user.getId());

        List<Integer> roleIdList = roleList.stream().map(Role::getId).collect(Collectors.toList());

        List<Permission> permissionList = userService.findPermissionListByRoleId(roleIdList);

        AuthUserDetails authUserDetails = new AuthUserDetails(user.getNickName(),user.getPassword(),roleList,permissionList);

        return authUserDetails;
    }


}
