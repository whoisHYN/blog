package com.hyn.dao;

import com.hyn.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Modified By:
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    /**
     * 查询首页推荐的博客
     * @param pageable
     * @return
     */
    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);

    /**
     * 按查询条件分页查询
     * @param query
     * @param pageable
     * @return
     */
    @Query("select b from Blog b where b.title like?1 or b.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);
}
