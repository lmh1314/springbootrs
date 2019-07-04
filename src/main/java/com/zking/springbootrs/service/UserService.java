package com.zking.springbootrs.service;

import com.zking.springbootrs.model.Mypermission;
import com.zking.springbootrs.model.User;

import java.util.List;

public interface UserService {
    /**
     * 增加
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 删除
     * @param uid
     * @return
     */
    Integer deleteUser(Integer uid);

    /**
     * 获得单个
     * @param uid
     * @return
     */
    User getUser(Integer uid);

    /**
     * 获得所有
     * @return
     */
    List<User> getAll();

    /**
     * 根据用户名获取  shiro的认证方法
     * @param uname
     * @return
     */
    User getUserByName(String uname);

    public List<Mypermission> getPermissionByUid(Integer uid);

}
