package com.haoze.admin.mapper;

import com.haoze.admin.model.UserRoleEntity;
import com.haoze.common.mapper.MyMapper;
/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface UserRoleMapper extends MyMapper<UserRoleEntity> {

    int insert(UserRoleEntity entity);

    void deleteByUserId(String id);
}
