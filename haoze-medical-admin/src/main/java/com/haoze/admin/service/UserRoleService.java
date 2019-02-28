package com.haoze.admin.service;

import com.haoze.admin.dto.system.UserDTO;


/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface UserRoleService {
    /**
     * 更新用户角色
     *
     * @param user 用户
     */
    void updateUserRole(UserDTO user);
}
