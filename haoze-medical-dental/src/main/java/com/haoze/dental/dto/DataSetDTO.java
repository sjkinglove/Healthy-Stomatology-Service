package com.haoze.dental.dto;

import com.haoze.dental.model.system.DataSetDetailEntity;
import com.haoze.dental.model.system.DataSetEntity;


import java.util.List;

/**
 * 数据集dto
 * @author fcx
 * @date 2019年2月19日09:35:31
 */
public class DataSetDTO {
    private DataSetEntity dataSetEntity;
    private List<DataSetDetailEntity> dataSetDetailEntities;

    public DataSetEntity getDataSetEntity() {
        return dataSetEntity;
    }

    public void setDataSetEntity(DataSetEntity dataSetEntity) {
        this.dataSetEntity = dataSetEntity;
    }

    public List<DataSetDetailEntity> getDataSetDetailEntities() {
        return dataSetDetailEntities;
    }

    public void setDataSetDetailEntities(List<DataSetDetailEntity> dataSetDetailEntities) {
        this.dataSetDetailEntities = dataSetDetailEntities;
    }
}
