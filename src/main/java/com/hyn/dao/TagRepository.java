package com.hyn.dao;

import com.hyn.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
