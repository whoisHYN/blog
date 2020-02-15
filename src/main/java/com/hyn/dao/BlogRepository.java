package com.hyn.dao;

import com.hyn.entity.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/10 12:54 下午
 * @Modified By:
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    /**
     * 查询首页推荐的博客
     * @return
     */
    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);
}
