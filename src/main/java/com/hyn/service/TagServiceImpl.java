package com.hyn.service;

import com.hyn.dao.TagRepository;
import com.hyn.entity.Tag;
import com.hyn.exception.NotFindException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/9 6:02 下午
 * @Modified By:
 */
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAllById(convertToLong(ids));
    }

    /**
     * 字符串转化成List<Long>，前端传过来类似于"1,2,3,4"，转成(1，2，3，4)
     * @param str
     * @return
     */
    private List<Long> convertToLong(String str) {
        List<Long> list = new ArrayList<>();
        if (null != str && !"".equals(str)) {
            String[] strings = str.split(",");
            for (String s : strings) {
                list.add(new Long(s));
            }
        }
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.getOne(id);
        if (t == null) {
            throw new NotFindException("不存在该类型");
        }
        BeanUtils.copyProperties(tag, t);
        return tagRepository.save(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.getByName(name);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
