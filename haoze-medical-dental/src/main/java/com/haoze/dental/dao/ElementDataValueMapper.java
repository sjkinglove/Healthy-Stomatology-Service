package com.haoze.dental.dao;


import com.haoze.common.mapper.MyMapper;
import com.haoze.dental.model.PrimaryValueEntity;



import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
public interface ElementDataValueMapper extends MyMapper<PrimaryValueEntity> {

    /**
     * 获取值域值查询列表
     */
    List<PrimaryValueEntity> listValue(String rangeId);
}