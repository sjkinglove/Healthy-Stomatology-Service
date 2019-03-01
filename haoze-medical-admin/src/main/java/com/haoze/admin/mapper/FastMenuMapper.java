package com.haoze.admin.mapper;

import com.haoze.admin.model.TFastMenu;
import com.haoze.common.mapper.MyMapper;

import java.util.List;

public interface FastMenuMapper extends MyMapper<TFastMenu> {
    /**
     * 根据用户ID查询所有快捷通道
     * */
    List<TFastMenu> listByUserId(String userId);

    /**
     * 新增快捷通道
     * */
    void insertFastMenu(TFastMenu fastMenu);

    /**
     * 启用快捷通道
     * */
    void clearFastMenu(TFastMenu fastMenu);
}
