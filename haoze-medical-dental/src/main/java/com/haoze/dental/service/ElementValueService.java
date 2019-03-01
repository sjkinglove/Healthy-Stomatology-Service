package com.haoze.dental.service;


import com.haoze.common.response.Result;
import com.haoze.common.service.Service;
import com.haoze.dental.dto.ElementValueDTO;
import com.haoze.dental.model.ElementValueEntity;

import java.util.List;

/**
 * @author zj
 * @date 2019/2/16
 */
public interface ElementValueService extends Service<ElementValueEntity> {

    /*
    * 值域查询集合
    * */
    List<ElementValueEntity> listDictionary(String queryString);

    /*
    * 值域下拉
    * */
    List<ElementValueEntity> listRangeOptions();

    /*
    * 保存值域
    * */
    Result saveRange(ElementValueDTO role);

    /*
    * 更新值域
    * */
    Result updateRange(ElementValueDTO role);

    /*
    * 删除值域
    * */
    Result deleteRange(String rangeId);

    /*
    * 停止使用
    * */
    Result stopRange(String rangeId);

    /*
    * 启动使用
    * */
    Result startRange(String rangeId);
}
