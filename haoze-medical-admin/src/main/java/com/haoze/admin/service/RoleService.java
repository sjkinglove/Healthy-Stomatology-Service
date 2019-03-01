package com.haoze.admin.service;

import com.haoze.admin.model.RoleEntity;
import com.haoze.common.service.Service;

/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface RoleService extends Service<RoleEntity> {
    /**
     * 根据角色ID停用该角色
     *
     * @param id 角色ID
     * @param stopFlag 停用标识
     */
    void updateStopFlagById(String id, String stopFlag);
    /**
     * 根据角色ID统计角色对应菜单数
     *
     * @param trId 角色ID
     */
    int countRoleMenuByRoleId(String trId);
}
