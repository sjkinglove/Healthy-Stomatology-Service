package com.haoze.dental.service;

import com.haoze.common.response.Result;
import com.haoze.common.service.Service;
import com.haoze.dental.dto.DataSetDTO;
import com.haoze.dental.model.DataSetEntity;


import java.util.List;

/**
 * 数据集service
 * @author fcx
 * @date 2019年2月19日09:14:09
 */
public interface DataSetService extends Service<DataSetEntity> {

    Result saveDto(DataSetDTO dataSetDTO);

    Result updateDto(DataSetDTO dataSetDTO);

    List<DataSetDTO> listAllDataSet();
}
