package com.haoze.admin.service;

import com.haoze.admin.model.MenuEntity;
import com.haoze.common.service.Service;

import java.util.List;

public interface MenuService extends Service<MenuEntity> {

    List<String> listByRoleId(String id);

    void saveRoleMenuRela(String roleId, String menuIds);

    List<MenuEntity> selectMenuByUserRole(String account);

    int countMenuRoleByMenuId(String menuId);
}
