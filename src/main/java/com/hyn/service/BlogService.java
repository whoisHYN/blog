package com.hyn.service;

import com.hyn.entity.Blog;
import com.hyn.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/10 12:29 下午
 * @Modified By:
 */
public interface BlogService {

    /**
     * 增
     * @param blog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 查
     * @param id
     * @return
     */
    Blog getBlog(Long id);

    /**
     * 按条件分页查Blog
     * @param pageable
     * @param blogQuery
     * @return
     */
    Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery);

    /**
     * 分页查所有Blog
     * @param pageable
     * @return
     */
    Page<Blog> listBlog(Pageable pageable);

    /**
     * 推荐的博客
     * @param size
     * @return
     */
    List<Blog> listRecommendBlogTop(Integer size);
    /**
     * 改
     * @param id
     * @param blog
     * @return
     */
    Blog updateBlog(Long id, Blog blog);

    /**
     * 删
     * @param id
     */
    void deleteBlog(Long id);
}
