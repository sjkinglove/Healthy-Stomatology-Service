package com.haoze.admin.mapper;

import com.haoze.admin.model.TUserRole;
import com.haoze.common.mapper.MyMapper;
/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface UserRoleMapper extends MyMapper<TUserRole> {

    int insert(TUserRole entity);

    void deleteByUserId(String id);
}
