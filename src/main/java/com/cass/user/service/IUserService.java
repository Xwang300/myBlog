package com.cass.user.service;


import com.cass.user.domain.Permission;
import com.cass.user.domain.Role;
import com.cass.user.domain.User;

import java.util.List;

public interface IUserService {

    User findByUserName(String userName);

    List<Role> findRoleListByUserId(Integer id);

    List<Permission> findPermissionListByRoleId(List<Integer> roleIdList);
}
