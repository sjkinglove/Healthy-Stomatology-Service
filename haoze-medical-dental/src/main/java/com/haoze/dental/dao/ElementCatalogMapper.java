package com.haoze.dental.dao;


import com.haoze.common.mapper.MyMapper;
import com.haoze.dental.model.ElementCatalogEntity;
import com.haoze.dental.model.IdsEntity;


import java.util.List;

/**
 * @author zj
 * @date 2019/2/16
 */
public interface ElementCatalogMapper extends MyMapper<ElementCatalogEntity> {

    /**
     * 获取数据元目录查询列表
     */
    List<ElementCatalogEntity> listDictionary(String queryString);

    /**
     * 获取数据元目录下拉
     */
    List<ElementCatalogEntity> listOptions();

    /**
     * 保存数据元目录
     */
    void saveRange(ElementCatalogEntity role);

    /**
     * 修改数据元目录
     */
    void updateRange(ElementCatalogEntity role);

    /**
     * 修改数据元
     */
    void updateRangeValue(ElementCatalogEntity role);

    /**
     * 删除数据元目录
     */
    void deleteRange(String id);

    /**
     * 删除数据元
     */
    void deleteRangeValue(String id);

    /**
     * 停止数据元目录
     */
    void stopRange(String id);

    /**
     * 停止数据元
     */
    void stopRangeValue(String id);

    /**
     * 启动数据元目录
     */
    void startRange(String id);

    /**
     * 启动数据元
     */
    void startRangeValue(String id);

    /**
     * 新增数据元目录父节点
     */
    void addDirectory(IdsEntity listId);

    /**
     * 获取数据元目录中数据元行数
     */
    int getCount(String parentId);

    /**
     * 获取数据元目录树
     */
    List<ElementCatalogEntity> listTree();
}