package com.haoze.dental.model.system;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据集实体类
 * @author fcx
 * @date 2019年2月19日08:49:28
 */
@Table(name = "SYS_DATA_SET")
public class DataSetEntity extends BaseEntity {

    @Id
    @Column(name = "DATASET_ID", nullable = false)
    private String datasetId; // 数据集数据ID

    @Column(name = "DATASET_CODE")
    private String datasetCode; // 数据集代码

    @Column(name = "DATASET_NAME")
    private String datasetName; // 数据集名称

    @Column(name = "DATASET_REMARK")
    private String datasetRemark; // 描述

    @Column(name = "PY_CODE")
    private String pyCode; // 拼音码

    @Column(name = "WB_CODE")
    private String wbCode; // 五笔码

    @Column(name = "READ_SERVICE")
    private String readService; // 数据集获取服务

    @Column(name = "INTRODUCE")
    private String introduce; // 入参描述

    @Column(name = "CLASS_NAME")
    private String className; // 类名

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getDatasetRemark() {
        return datasetRemark;
    }

    public void setDatasetRemark(String datasetRemark) {
        this.datasetRemark = datasetRemark;
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }

    public String getReadService() {
        return readService;
    }

    public void setReadService(String readService) {
        this.readService = readService;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroducee(String introduce) {
        this.introduce = introduce;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
