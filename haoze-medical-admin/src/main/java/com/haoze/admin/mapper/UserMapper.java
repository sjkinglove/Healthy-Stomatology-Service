package com.haoze.admin.mapper;

import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.model.TUser;
import com.haoze.admin.model.TUserOrganization;
import com.haoze.admin.model.TUserRole;
import com.haoze.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface UserMapper extends MyMapper<TUser> {
    /**
     * 获取所有用户以及对应角色
     *
     * @return 用户列表
     */
    List<UserDTO> findAllUserWithRole(@Param("queryString") String queryString);

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
    void insertUserRoleRela(TUserRole entity);

    /**
     * 保存角色用户关系
     *
     * @param entity
     */
    void insertUserOrganizationRela(TUserOrganization entity);

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
