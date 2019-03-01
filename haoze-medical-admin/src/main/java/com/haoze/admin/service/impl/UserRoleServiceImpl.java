package com.haoze.admin.service.impl;

import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.mapper.UserRoleMapper;
import com.haoze.admin.model.UserRoleEntity;
import com.haoze.admin.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public void updateUserRole(final UserDTO user) {

        userRoleMapper.deleteByUserId(user.getTuId());
        final UserRoleEntity e = new UserRoleEntity();
        e.setTurId(user.getTuId());
        e.setTrId(user.getRoleId());
        userRoleMapper.insert(e);
    }
}
