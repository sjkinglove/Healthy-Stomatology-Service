package com.haoze.dental.dao;

import com.haoze.common.mapper.MyMapper;
import com.haoze.dental.dto.DataSetDTO;
import com.haoze.dental.model.DataSetEntity;

import java.util.List;

/**
 * 数据集dao
 * @author fcx
 * @date 2019-2-19 09:13:15
 */
public interface DataSetMapper extends MyMapper<DataSetEntity> {

    List<DataSetDTO> listAllDataSet();
}
