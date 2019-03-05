package com.haoze.dental.dao.system;


import com.haoze.common.mapper.MyMapper;
import com.haoze.dental.model.system.ElementEntity;

import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
public interface ElementMapper extends MyMapper<ElementEntity> {

    /**
     * 获数据元查询列表
     * @return 用户列表
     */
    List<ElementEntity> listElement(String queryString);

    /**
     * 获取数据元下拉
     * @return id,name
     */
    List<ElementEntity> listOptions();

    /*
     * 保存数据元
     */
    void saveRange(ElementEntity role);

    /*
     * 更新数据元
     * */
    void updateRange(ElementEntity role);

    /*
     * 删除数据元
     */
    void deleteRange(String id);

    /*
     * 停止使用
     * */
    void stopRange(String id);

    /*
     * 开启使用
     * */
    void startRange(String id);

    /*
    * 获取数据元目录中数据元父id
    * */
    List<ElementEntity> getParentId(String id);

    /*
    * 获取数据元目录中数据元条数
    * */
    int getCount(String id);

    /*
    * 获取数据元单条实体类
    * */
    List<ElementEntity> getList(String id);
}