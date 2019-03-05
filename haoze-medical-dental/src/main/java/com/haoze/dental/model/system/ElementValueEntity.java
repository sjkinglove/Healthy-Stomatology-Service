package com.haoze.dental.model.system;



import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zj
 * @date 2018/12/6
 */
@Table(name = "SYS_PRIMARY_DATA")
public class ElementValueEntity {

    @Id
    @Column(name = "PRIMARYDATA_ID")
    private String primaryDataId;

    @Column(name = "DATA_VERSION")
    private String dataVersion;// 数据版本

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;// 数据创建时间

    @Column(name = "GMT_MODIFY")
    private Date gmtModify;// 数据最后修改时间

    @Column(name = "HOSPITAL_ID")
    private String hospitalId;// 医疗机构

    @Column(name = "PRIMARY_DATA_CODE")
    private String primaryDataCode;// 目录代码

    @Column(name = "PRIMARY_DATA_NAME")
    private String primaryDataName;// 名称

    @Column(name = "RANGE_CODE")
    private String rangeCode; // 排序

    @Column(name = "IDENTIFICATION_FLAG")
    private String identificationFlag;// 上级ID

    @Column(name = "DATA_VIEW_TYPE")
    private String dataViewType;// 关联数据元ID

    @Column(name = "PY_CODE")
    private String pyCode;// 类型

    @Column(name = "WB_CODE")
    private String wbCode;// 类型

    @Column(name = "STOP_FLAG")
    private String stopFlag;// 停用标志

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

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}
