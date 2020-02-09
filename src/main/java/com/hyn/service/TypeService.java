package com.hyn.service;

import com.hyn.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/8 1:01 下午
 * @Modified By:
 */
public interface TypeService {

    /**
     * 保存Type
     * @param type
     * @return
     */
    Type saveType(Type type);

    /**
     * 根据id查询Type
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 分页查询Type
     * @param pageable
     * @return
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 更新Type
     * @param id
     * @param type
     * @return
     */
    Type updateType(Long id, Type type);

    /**
     * 删除Type
     * @param id
     */
    void deleteType(Long id);
}
