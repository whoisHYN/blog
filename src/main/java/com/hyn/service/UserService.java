package com.hyn.service;

import com.hyn.entity.User;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/7 1:46 下午
 * @Modified By:
 */
public interface UserService {

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username, String password);
}
