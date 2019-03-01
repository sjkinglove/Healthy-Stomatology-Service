package com.haoze.dental.dto;



import com.haoze.dental.model.PrimaryValueEntity;


import java.util.Date;
import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */

public class ElementValueDTO {

    private String primaryDataId;

    private String dataVersion;// 数据版本

    private Date gmtCreate;// 数据创建时间

    private Date gmtModify;// 数据最后修改时间

    private String hospitalId;// 医疗机构

    private String primaryDataCode;// 目录代码

    private String primaryDataName;// 名称

    private String rangeCode; // 排序

    private String identificationFlag;// 上级ID

    private String dataViewType;// 关联数据元ID

    private String pyCode;// 类型

    private String wbCode;// 类型

    private String stopFlag;// 停用标志

    private List<PrimaryValueEntity> valueList;

    public String getPrimaryDataId() {
        return primaryDataId;
    }

    public void setPrimaryDataId(String primaryDataId) {
        this.primaryDataId = primaryDataId;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getPrimaryDataCode() {
        return primaryDataCode;
    }

    public void setPrimaryDataCode(String primaryDataCode) {
        this.primaryDataCode = primaryDataCode;
    }

    public String getPrimaryDataName() {
        return primaryDataName;
    }

    public void setPrimaryDataName(String primaryDataName) {
        this.primaryDataName = primaryDataName;
    }

    public String getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(String rangeCode) {
        this.rangeCode = rangeCode;
    }

    public String getIdentificationFlag() {
        return identificationFlag;
    }

    public void setIdentificationFlag(String identificationFlag) {
        this.identificationFlag = identificationFlag;
    }

    public String getDataViewType() {
        return dataViewType;
    }

    public void setDataViewType(String dataViewType) {
        this.dataViewType = dataViewType;
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

    public List<PrimaryValueEntity> getValueList() {
        return valueList;
    }

    public void setValueList(List<PrimaryValueEntity> valueList) {
        this.valueList = valueList;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}
