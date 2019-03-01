package com.haoze.dental.dao;


import com.haoze.common.mapper.MyMapper;
import com.haoze.dental.dto.ElementValueDTO;
import com.haoze.dental.model.ElementValueEntity;
import com.haoze.dental.model.PrimaryValueEntity;


import java.util.List;

/**
 * @author zj
 * @date 2019/2/16
 */
public interface ElementValueMapper extends MyMapper<ElementValueEntity> {

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
    void saveRange(ElementValueDTO role);

    /*
     * 更新值域
     * */
    void updateRange(ElementValueDTO role);

    /*
    * 保存值域值
    * */
    void saveRangeValue(PrimaryValueEntity role);

    /*
     * 修改值域值
     * */
    void updateRangeValue(PrimaryValueEntity role);

    /*
     * 删除值域
     * */
    void deleteRange(String rangeId);

    /*
     * 删除值域值
     * */
    void deleteRangeValue(String rangeId);

    /*
     * 停止使用
     * */
    void stopRange(String rangeId);

    /*
     * 启动使用
     * */
    void startRange(String rangeId);

}