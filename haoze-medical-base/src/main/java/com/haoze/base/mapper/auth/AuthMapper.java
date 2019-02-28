package com.haoze.base.mapper.auth;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyb
 * @date 2018/06/09
 */
public interface AuthMapper {

    int countRole(@Param("account") String account, @Param("roleList") List<String> roleList);

    int countPermission(@Param("account") String account, @Param("permissionList") List<String> permissionList);
}