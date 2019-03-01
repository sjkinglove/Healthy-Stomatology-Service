package com.haoze.dental.service;


import com.haoze.common.response.Result;
import com.haoze.common.service.Service;
import com.haoze.dental.model.ElementEntity;

import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
public interface ElementService extends Service<ElementEntity> {

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
    Result saveRange(ElementEntity role);

    /*
    * 更新数据元
    * */
    Result updateRange(ElementEntity role);

    /*
    * 删除数据元
    */
    Result deleteRange(String id);

    /*
    * 停止使用
    * */
    Result stopRange(String id);

    /*
    * 开启使用
    * */
    Result startRange(String id);
}
