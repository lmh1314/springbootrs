package com.zking.springbootrs.service.impl;

import com.zking.springbootrs.dao.UserMapper;
import com.zking.springbootrs.model.Mypermission;
import com.zking.springbootrs.model.User;
import com.zking.springbootrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer deleteUser(Integer uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public User getUser(Integer uid) {
        return userMapper.getUser(uid);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getUserByName(String uname) {
        return userMapper.getUserByName(uname);
    }

    @Override
    public List<Mypermission> getPermissionByUid(Integer uid) {
        return userMapper.getPermissionByUid(uid);
    }
}
