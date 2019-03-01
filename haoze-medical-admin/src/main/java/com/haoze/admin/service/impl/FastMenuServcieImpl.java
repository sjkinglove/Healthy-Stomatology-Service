package com.haoze.admin.service.impl;

import com.haoze.admin.mapper.FastMenuMapper;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FastMenuServcieImpl extends AbstractService<FastMenuEntity> implements FastMenuServcie {
    @Resource
    private FastMenuMapper fastMenuMapper;

    @Override
    public void deleteById(Object id) {
        Condition condition = new Condition(FastMenuEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("parentId", id);
        fastMenuMapper.deleteByCondition(condition);
        fastMenuMapper.deleteByPrimaryKey(id);
    }
}
