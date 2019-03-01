package com.haoze.dental.service;


import com.haoze.common.service.Service;
import com.haoze.dental.model.PrimaryValueEntity;


import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
public interface ElementDataValueService extends Service<PrimaryValueEntity> {

    /*
    * 值域值列表
    * */
    List<PrimaryValueEntity> listValue(String rangeId);

}
