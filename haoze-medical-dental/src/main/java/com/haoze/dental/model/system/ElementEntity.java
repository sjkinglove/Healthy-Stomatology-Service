package com.haoze.dental.model.system;



import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zj
 * @date 2018/12/6
 */
@Table(name = "SYS_DATA_ELEMENT")
public class ElementEntity extends BaseEntity {

    @Id
    @Column(name = "ELEMENT_ID")
    private String elementId;

    @Column(name = "ELEMENT_CODE")
    private String elementCode;// 目录代码

    @Column(name = "ELEMENT_IDENTIFICATION")
    private String elementIdentification;// 名称

    @Column(name = "ELEMENT_NAME")
    private String elementName; // 排序

    @Column(name = "ELEMENT_REMARK")
    private String elementRemark;// 上级ID

    @Column(name = "ELEMENT_DATA_TYPE")
    private String elementDataType;// 关联数据元ID

    @Column(name = "ELEMENT_FORMAT")
    private String elementFormat;// 类型

    @Column(name = "ELEMENT_STANDARD_ID")
    private String elementStandardId;// 类型

    @Column(name = "ELEMENT_PD_ID")
    private String elementPdId;// 停用标志

    @Column(name = "ELEMENT_BD_ID")
    private String elementBdId;// 上级ID

    @Column(name = "ELEMENT_FD_ID")
    private String elementFdId;// 关联数据元ID

    @Column(name = "ELEMENT_DATA_TYPE_ID")
    private String elementDataTypeId;// 类型

    @Column(name = "STOP_FLAG")
    private String stopFlag;// 类型

    @Column(name = "PY_CODE")
    private String pyCode;// 停用标志

    @Column(name = "WB_CODE")
    private String wbCode;// 停用标志

    private String parentIds;// 目录id

    @Column(name = "INPUT_FLAG")
    private String inputFlag;// 停用标志

    @Column(name = "MULTIPLE_FLAG")
    private String mulitpleFlag;// 停用标志

    @Column(name = "MAX_VALUE")
    private String maxValue;// 停用标志

    @Column(name = "MIN_VALUE")
    private String minValue;// 停用标志

    @Column(name = "INTERVAL_VALUE")
    private String intervalValue;// 停用标志

    @Column(name = "FORMAT_DATA_VALUE")
    private String formatDataValue;// 停用标志

    @Column(name = "ELEMENT_TYPE")
    private String elementType;// 停用标志

    @Column(name = "DICT_ID")
    private String dictId;// 停用标志

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public String getElementIdentification() {
        return elementIdentification;
    }

    public void setElementIdentification(String elementIdentification) {
        this.elementIdentification = elementIdentification;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementRemark() {
        return elementRemark;
    }

    public void setElementRemark(String elementRemark) {
        this.elementRemark = elementRemark;
    }

    public String getElementDataType() {
        return elementDataType;
    }

    public void setElementDataType(String elementDataType) {
        this.elementDataType = elementDataType;
    }

    public String getElementFormat() {
        return elementFormat;
    }

    public void setElementFormat(String elementFormat) {
        this.elementFormat = elementFormat;
    }

    public String getElementStandardId() {
        return elementStandardId;
    }

    public void setElementStandardId(String elementStandardId) {
        this.elementStandardId = elementStandardId;
    }

    public String getElementPdId() {
        return elementPdId;
    }

    public void setElementPdId(String elementPdId) {
        this.elementPdId = elementPdId;
    }

    public String getElementBdId() {
        return elementBdId;
    }

    public void setElementBdId(String elementBdId) {
        this.elementBdId = elementBdId;
    }

    public String getElementFdId() {
        return elementFdId;
    }

    public void setElementFdId(String elementFdId) {
        this.elementFdId = elementFdId;
    }

    public String getElementDataTypeId() {
        return elementDataTypeId;
    }

    public void setElementDataTypeId(String elementDataTypeId) {
        this.elementDataTypeId = elementDataTypeId;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
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

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getInputFlag() {
        return inputFlag;
    }

    public void setInputFlag(String inputFlag) {
        this.inputFlag = inputFlag;
    }

    public String getMulitpleFlag() {
        return mulitpleFlag;
    }

    public void setMulitpleFlag(String mulitpleFlag) {
        this.mulitpleFlag = mulitpleFlag;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getIntervalValue() {
        return intervalValue;
    }

    public void setIntervalValue(String intervalValue) {
        this.intervalValue = intervalValue;
    }

    public String getFormatDataValue() {
        return formatDataValue;
    }

    public void setFormatDataValue(String formatDataValue) {
        this.formatDataValue = formatDataValue;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }
}
