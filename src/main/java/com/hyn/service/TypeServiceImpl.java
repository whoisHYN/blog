package com.hyn.service;

import com.hyn.dao.TypeRepository;
import com.hyn.entity.Type;
import com.hyn.exception.NotFindException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/8 1:06 下午
 * @Modified By:
 */
@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Type getType(Long id) {
        return typeRepository.getOne(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer number) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, number, sort);
        return typeRepository.findTop(pageable);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.getOne(id);
        if (t == null) {
            throw new NotFindException("不存在该类型");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.getTypeByName(name);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
