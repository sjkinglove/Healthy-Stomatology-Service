package com.haoze.admin.mapper;

import com.haoze.admin.model.MenuEntity;
import com.haoze.admin.model.RoleMenuEntity;
import com.haoze.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends MyMapper<MenuEntity> {
    List<String> listByRoleId(String id);

    void insertRoleMenuRela(RoleMenuEntity menu);

    void clearRoleMenuRela(String roleId);

    void updateSortNoForEnlarge(Map<String, Object> map);

    void updateSortNoForReduce(Map<String, Object> map);

    List<MenuEntity> selectMenuByUserRole(@Param("account") String account);

    int countMenuRoleByMenuId(@Param("menuId") String menuId);

    String selectCompleteMenuUrlByMenuId(String menuId);
}
