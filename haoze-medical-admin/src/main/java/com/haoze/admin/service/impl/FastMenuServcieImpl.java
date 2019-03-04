package com.haoze.admin.service.impl;

import com.haoze.admin.core.Status;
import com.haoze.admin.mapper.FastMenuMapper;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.admin.model.MenuEntity;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

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

    }

    @Override
    public List<FastMenuEntity> listByUserId(String id) {

        Condition condition = new Condition(FastMenuEntity.class);

        condition.setOrderByClause("FAST_MENU_SORT ASC");

        Example.Criteria criteria = condition.createCriteria();

        criteria.andEqualTo("tuId", id);

        final List<FastMenuEntity> list = fastMenuMapper.selectByCondition(condition);
        return list;
    }

    @Override
    public void saveFastMenu(FastMenuEntity entity) {

        fastMenuMapper.updateSortNoForEnlarge(entity.getFastMenuSort());//更新其他快速通道序号

        entity.setClickNum(Integer.valueOf(Status.INIT_CLICK_NUM.getValue()));//点击次数初始设置为0

        fastMenuMapper.insertFastMenu(entity);
    }

    @Override
    public List<FastMenuEntity> selectMenuByUserRole(String account) {
        return null;
    }

    @Override
    public int countFastMenuByUserId(String userId) {
        return 0;
    }
}
