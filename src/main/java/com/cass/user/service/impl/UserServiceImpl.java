package com.cass.user.service.impl;

import com.cass.user.domain.Permission;
import com.cass.user.domain.Role;
import com.cass.user.domain.User;
import com.cass.user.mapper.UserMapper;
import com.cass.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public List<Role> findRoleListByUserId(Integer id) {
        return userMapper.findRoleListByUserId(id);
    }

    @Override
    public List<Permission> findPermissionListByRoleId(List<Integer> roleIdList) {
//        return userMapper.findPermissionListByRoleId(roleIdList);
        return null;
    }
}


