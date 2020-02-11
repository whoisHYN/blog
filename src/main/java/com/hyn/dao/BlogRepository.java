package com.hyn.dao;

import com.hyn.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/10 12:54 下午
 * @Modified By:
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

}
