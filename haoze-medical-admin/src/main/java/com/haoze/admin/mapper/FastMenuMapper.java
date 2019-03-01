package com.haoze.admin.mapper;

import com.haoze.admin.model.FastMenuEntity;
import com.haoze.common.mapper.MyMapper;

import java.util.List;

public interface FastMenuMapper extends MyMapper<FastMenuEntity> {
    /**
     * 根据用户ID查询所有快捷通道
     * */
    List<FastMenuEntity> listByUserId(String userId);

    /**
     * 新增快捷通道
     * */
    void insertFastMenu(FastMenuEntity fastMenu);

    /**
     * 启用快捷通道
     * */
    void clearFastMenu(FastMenuEntity fastMenu);
}
