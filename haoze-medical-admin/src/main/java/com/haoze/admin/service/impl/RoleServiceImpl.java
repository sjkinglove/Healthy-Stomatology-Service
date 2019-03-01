package com.haoze.admin.service.impl;

import com.haoze.admin.mapper.RoleMapper;
import com.haoze.admin.mapper.RoleMenuMapper;
import com.haoze.admin.model.RoleEntity;
import com.haoze.admin.model.RoleMenuEntity;
import com.haoze.admin.service.RoleService;
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
public class RoleServiceImpl extends AbstractService<RoleEntity> implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleMenuMapper roleMenuRelaMapper;

    @Override
    public void updateStopFlagById(String id, String stopFlag) {
        roleMapper.updateStopFlagById(id, stopFlag);
    }

    @Override
    public void deleteByIds(String ids) {
        String[] idsArr = ids.split(",");
        String newId = "";
        for (int i = 0; i < idsArr.length; i++) {
            if (i == idsArr.length - 1) {
                newId += "'" + idsArr[i] + "'";
            } else {
                newId += "'" + idsArr[i] + "',";
            }
            //删除子记录
            Condition condition = new Condition(RoleMenuEntity.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("trId", idsArr[i]);
            roleMenuRelaMapper.deleteByCondition(condition);
        }
        //删除主记录
        roleMapper.deleteByIds(newId);
    }

    @Override
    public int countRoleMenuByRoleId(String roleId) {
        return roleMapper.countRoleMenuByRoleId(roleId);
    }
}
