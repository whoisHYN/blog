package com.hyn.service;

import com.hyn.entity.User;

/**
 * @Author: HYN
 * @Description:
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
