package com.haoze.dental.model;



import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zj
 * @date 2018/12/6
 */
@Table(name = "SYS_DATA_ELEMENT_DICTIONARY")
public class ElementCatalogEntity {

    @Id
    @Column(name = "DICTIONARY_ID")
    private String dictionaryId;

    @Column(name = "DATA_VERSION")
    private String dataVersion;// 数据版本

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;// 数据创建时间

    @Column(name = "GMT_MODIFY")
    private Date gmtModify;// 数据最后修改时间

    @Column(name = "HOSPITAL_ID")
    private String hospitalId;// 医疗机构

    @Column(name = "DICTIONARY_CODE")
    private String dictionaryCode;// 目录代码

    @Column(name = "DICTIONARY_NAME")
    private String dictionaryName;// 名称

    @Column(name = "SORT_NO")
    private int sortNo; // 排序

    @Column(name = "PARENT_ID")
    private String parentId;// 上级ID

    @Column(name = "ELEMENT_ID")
    private String elementId;// 关联数据元ID

    @Column(name = "DICTIONARY_TYPE")
    private String dictionaryType;// 类型

    @Column(name = "STOP_FLAG")
    private String stopFlag;// 停用标志

    public String getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId;
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

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType) {
        this.dictionaryType = dictionaryType;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public void initAdd(){
        this.setDataVersion("1.0");
        this.setHospitalId("常州二院");
        this.setGmtCreate(new Date());
        this.setGmtModify(new Date());
    }

    public void initUpdate(){
        this.setGmtModify(new Date());
    }
}
