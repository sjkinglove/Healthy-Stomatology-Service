package com.haoze.admin.service;

import com.haoze.admin.model.TMenu;
import com.haoze.common.service.Service;

import java.util.List;

public interface MenuService extends Service<TMenu> {

    List<String> listByRoleId(String id);

    void saveRoleMenuRela(String roleId, String menuIds);

    List<TMenu> selectMenuByUserRole(String account);

    int countMenuRoleByMenuId(String menuId);
}
