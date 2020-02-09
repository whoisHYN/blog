package com.hyn.dao;

import com.hyn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/7 1:48 下午
 * @Modified By:
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
