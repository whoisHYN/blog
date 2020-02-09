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
