package com.hyn.dao;

import com.hyn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: HYN
 * @Description:
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
