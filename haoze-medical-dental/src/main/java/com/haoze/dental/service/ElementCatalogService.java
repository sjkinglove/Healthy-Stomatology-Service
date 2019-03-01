package com.haoze.dental.service;


import com.haoze.common.response.Result;
import com.haoze.common.service.Service;
import com.haoze.dental.model.ElementCatalogEntity;

import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
public interface ElementCatalogService extends Service<ElementCatalogEntity> {

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
    Result saveRange(ElementCatalogEntity role);

    /**
     * 修改数据元目录
     */
    Result updateRange(ElementCatalogEntity role);

    /**
     * 删除数据元目录
     */
    Result deleteRange(String id);

    /**
     * 停止数据元目录
     */
    Result stopRange(String id);

    /**
     * 启动数据元目录
     */
    Result startRange(String id);
}
