package com.haoze.admin.mapper;

import com.haoze.admin.model.TMenu;
import com.haoze.admin.model.TRoleMenu;
import com.haoze.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends MyMapper<TMenu> {
    List<String> listByRoleId(String id);

    void insertRoleMenuRela(TRoleMenu menu);

    void clearRoleMenuRela(String roleId);

    void updateSortNoForEnlarge(Map<String, Object> map);

    void updateSortNoForReduce(Map<String, Object> map);

    List<TMenu> selectMenuByUserRole(@Param("account") String account);

    int countMenuRoleByMenuId(@Param("menuId") String menuId);
}
