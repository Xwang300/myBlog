package com.cass.user.mapper;

import com.cass.user.domain.Permission;
import com.cass.user.domain.Role;
import com.cass.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {


    public User findUserByUserName(String userName);

    public List<Role> findRoleListByUserId(Integer id);

    public List<Permission> findPermissionListByRoleId(List<Integer> roleIdList);

}
