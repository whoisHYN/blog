package com.hyn.service;

import com.hyn.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/9 5:36 下午
 * @Modified By:
 */
public interface TagService {

    /**
     * 保存Tag
     * @param tag
     * @return
     */
    Tag saveTag(Tag tag);

    /**
     * 根据ID查询Tag
     * @param id
     * @return
     */
    Tag getTag(Long id);

    /**
     * 分页查询Tag
     * @param pageable
     * @return
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 查询所有Tag
     * @return
     */
    List<Tag> listTag();

    /**
     * 查出博客数量最多的前面几个
     * @param size
     * @return
     */
    List<Tag> listTagTop(Integer size);

    /**
     * 根据前端传过来的ID查询
     * @param ids
     * @return
     */
    List<Tag> listTag(String ids);
    /**
     * 更新Tag
     * @param id
     * @param tag
     * @return
     */
    Tag updateTag(Long id, Tag tag);

    /**
     * 根据name查询Tag
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 删除Tag
     * @param id
     */
    void deleteTag(Long id);
}
