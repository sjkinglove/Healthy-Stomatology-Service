package com.haoze.dental.model;



import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zj
 * @date 2018/12/6
 */
@Table(name = "SYS_PRIMARY_DATA_VALUE")
public class PrimaryValueEntity {

    @Id
    @Column(name = "DATAVALUE_ID")
    private String datavalueId;

    @Column(name = "DATA_VERSION")
    private String dataVersion;// 数据版本

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;// 数据创建时间

    @Column(name = "GMT_MODIFY")
    private Date gmtModify;// 数据最后修改时间

    @Column(name = "HOSPITAL_ID")
    private String hospitalId;// 医疗机构

    @Column(name = "PRIMARYDATA_ID")
    private String primaryDataId;// 目录代码

    @Column(name = "DATAVERSION_ID")
    private String dataversionId;// 名称

    @Column(name = "SERIAL_NUMBER")
    private int serialNumber; // 排序

    @Column(name = "DATA_VALUE")
    private String dataValue;// 上级ID

    @Column(name = "DATA_VALUE_REMARK")
    private String dataValueRemark;// 关联数据元ID

    @Column(name = "PARENT_DATAVALUE_ID")
    private String parentDatavalueId;// 类型

    @Column(name = "PY_CODE")
    private String pyCode;// 类型

    @Column(name = "WB_CODE")
    private String wbCode;// 类型

    public String getDatavalueId() {
        return datavalueId;
    }

    public void setDatavalueId(String datavalueId) {
        this.datavalueId = datavalueId;
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

    public String getPrimaryDataId() {
        return primaryDataId;
    }

    public void setPrimaryDataId(String primaryDataId) {
        this.primaryDataId = primaryDataId;
    }

    public String getDataversionId() {
        return dataversionId;
    }

    public void setDataversionId(String dataversionId) {
        this.dataversionId = dataversionId;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataValueRemark() {
        return dataValueRemark;
    }

    public void setDataValueRemark(String dataValueRemark) {
        this.dataValueRemark = dataValueRemark;
    }

    public String getParentDatavalueId() {
        return parentDatavalueId;
    }

    public void setParentDatavalueId(String parentDatavalueId) {
        this.parentDatavalueId = parentDatavalueId;
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
}
