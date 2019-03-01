package com.haoze.dental.service;


import com.haoze.common.response.Result;
import com.haoze.common.service.Service;
import com.haoze.dental.model.ElementCatalogEntity;
import com.haoze.dental.model.IdsEntity;


import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
public interface ElementRelationService extends Service<ElementCatalogEntity> {
    /*
    * 数据元目录引用数据元目录
    * */
    Result addDirectory(IdsEntity listId);

    /*
    * 数据元目录引用数据元
    * */
    Result addElement(IdsEntity listId);

    /*
    * 数据元目录树
    * */
    List<ElementCatalogEntity> listTree();
}
