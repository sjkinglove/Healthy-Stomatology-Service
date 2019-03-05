package com.haoze.admin.mapper;

import com.haoze.admin.dto.system.FastMenuDTO;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

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
     * 更新快捷通道
     * */
    void updateFastMenu(FastMenuEntity fastMenu);


    /**
     * 快捷通道启用状态变更
     * */
    void updateStopFlagById(@Param("id") String id, @Param("openState") String stopFlag);

    /**
     * 快捷通道序号加一
     * */
    void updateSortNoForEnlarge(String sort);
    /**
     * 快捷通道序号减一
     * */
    void updateSortNoForReduce(String sort);

    /**
     * 首页快速通道列表接口
     * */
    List<FastMenuDTO> list(String id);


}
