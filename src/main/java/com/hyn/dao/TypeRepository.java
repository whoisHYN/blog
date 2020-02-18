package com.hyn.dao;

import com.hyn.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Modified By:
 */
public interface TypeRepository extends JpaRepository<Type, Long> {

    /**
     * 根据名称查询Type
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 根据对应的博客数量查出前几个
     * @param pageable
     * @return
     */
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
