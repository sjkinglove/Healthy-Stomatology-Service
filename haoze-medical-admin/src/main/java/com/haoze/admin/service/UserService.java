package com.haoze.admin.service;

import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.model.TUser;
import com.haoze.common.service.Service;

import java.util.List;

/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface UserService extends Service<TUser> {
    /**
     * 获取所有用户以及对应角色
     *
     * @return 用户列表
     */
    List<UserDTO> findAllUserWithRole(String queryString);

    /**
     * 按条件查询用户信息
     *
     * @param column 列名
     * @param param  参数map
     * @return 用户
     */
    UserDTO findDetailBy(String column, Object param);

    /**
     * 验证用户密码
     *
     * @param rawPassword     原密码
     * @param encodedPassword 加密后的密码
     * @return boolean
     */
    boolean verifyPassword(String rawPassword, String encodedPassword);

    /**
     * 用户密码加密
     */
    String encodePassword(String password);

    /**
     * 按条件查询用户信息
     *
     * @param user 列名
     */
    void saveUserAndRoleAndOrganizagion(UserDTO user);

    /**
     * 按条件查询用户信息
     *
     * @param user 列名
     */
    void updateUserAndRoleAndDept(UserDTO user);
}
