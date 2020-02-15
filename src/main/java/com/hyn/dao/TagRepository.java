package com.hyn.dao;

import com.hyn.entity.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/9 6:03 下午
 * @Modified By:
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    /**
     * 根据name查询Tag
     * @param name
     * @return
     */
    Tag getByName(String name);

    /**
     * 根据对应博客数量查出前面几个
     * @param pageable
     * @return
     */
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
