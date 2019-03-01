package com.haoze.admin.mapper;

import com.haoze.admin.model.RoleEntity;
import com.haoze.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface RoleMapper extends MyMapper<RoleEntity> {
    void updateStopFlagById(@Param("id") String id, @Param("stopFlag") String stopFlag);

    int countRoleMenuByRoleId(@Param("roleId") String roleId);
}
