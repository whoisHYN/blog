package com.hyn.service;

import com.hyn.dao.UserRepository;
import com.hyn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/7 1:47 下午
 * @Modified By:
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
