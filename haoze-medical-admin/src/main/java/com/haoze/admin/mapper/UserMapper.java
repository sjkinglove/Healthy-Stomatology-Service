package com.haoze.admin.mapper;

import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.model.UserEntity;
import com.haoze.admin.model.UserOrganizationEntity;
import com.haoze.admin.model.UserRoleEntity;
import com.haoze.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface UserMapper extends MyMapper<UserEntity> {
    /**
     * 获取所有用户以及对应角色
     *
     * @return 用户列表
     */
    List<UserDTO> findAllUserWithRole(@Param("queryString") String queryString);

    /**
     * 获取机构管理员列表
     *
     * @return 用户列表
     */
    List<UserDTO> findManageUserByToId(String toId);
    /**
     * 获取用户关联信息
     *
     * @return
     */
    UserDTO findUserRelWithLoginName(String account);

    /**
     * 按条件查询用户信息
     *
     * @param param 参数map
     * @return 用户
     */
    UserDTO findDetailBy(Map<String, Object> param);

    /**
     * 保存角色用户关系
     *
     * @param entity
     */
    void insertUserRoleRela(UserRoleEntity entity);

    /**
     * 保存角色用户关系
     *
     * @param entity
     */
    void insertUserOrganizationRela(UserOrganizationEntity entity);

    /**
     * 保存角色用户关系
     *
     * @param userId
     */
    void clearUserRoleRela(String userId);

    /**
     * 保存角色用户关系
     *
     * @param userId
     */
    void clearUserOrganizationRela(String userId);

    /**
     * 获取上级机构ID
     *
     * @param id
     */
    String getParentOrganizationId(String id);
}
